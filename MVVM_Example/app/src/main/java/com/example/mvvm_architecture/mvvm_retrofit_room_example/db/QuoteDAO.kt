package com.example.mvvm_architecture.mvvm_retrofit_room_example.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvm_architecture.mvvm_retrofit_room_example.model.Result

@Dao
interface QuoteDAO {

    @Query("SELECT * from quoteTable")
    suspend fun getQuotes(): List<Result>

    @Insert
    suspend fun insertQuotes(quote: List<Result>)
}