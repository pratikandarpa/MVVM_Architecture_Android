package com.example.databindingroom.databaseTest

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Convertors::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDAO

    companion object {

        val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(0)")
                Log.i("DataData", "Migration Excuted")
            }
        }

        @Volatile
        private var INSTANCEVARIABLE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase {
            if (INSTANCEVARIABLE == null) {
                synchronized(this) {
                    INSTANCEVARIABLE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "ContactDB"
                    ).addMigrations(migration_1_2).build()
                }
            }
            return INSTANCEVARIABLE!!
        }
    }
}