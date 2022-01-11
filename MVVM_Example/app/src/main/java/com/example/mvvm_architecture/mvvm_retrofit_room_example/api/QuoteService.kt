package com.example.mvvm_architecture.mvvm_retrofit_room_example.api

import com.example.mvvm_architecture.mvvm_retrofit_room_example.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuoteList>

}