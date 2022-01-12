package com.example.mvvm_architecture.mvvm_retrofit_room_example.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm_architecture.mvvm_retrofit_room_example.model.Result

@Database(entities = [Result::class], version = 1)
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
                        "QuoteDBRetrofit"
                    ).build()
                }
            }
            return INSTANCEVARIABLE!!
        }
    }
}