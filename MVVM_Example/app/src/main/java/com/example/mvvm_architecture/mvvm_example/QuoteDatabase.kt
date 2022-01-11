package com.example.mvvm_architecture.mvvm_example

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDAO

    companion object {

        @Volatile
        private var INSTANCEVARIABLE: QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {
            if (INSTANCEVARIABLE == null) {
                synchronized(this) {
                    INSTANCEVARIABLE = Room.databaseBuilder(
                        context.applicationContext,
                        QuoteDatabase::class.java,
                        "QuoteDB"
                    ).createFromAsset("quotes.db").build()
                }
            }
            return INSTANCEVARIABLE!!
        }
    }
}