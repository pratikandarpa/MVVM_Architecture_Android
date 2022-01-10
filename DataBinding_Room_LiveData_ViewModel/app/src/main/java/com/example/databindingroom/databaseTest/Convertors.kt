package com.example.databindingroom.databaseTest

import androidx.room.TypeConverter
import java.util.*

class Convertors {

    @TypeConverter
    fun fromDateToLong(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(date: Long): Date {
        return Date(date)
    }
}