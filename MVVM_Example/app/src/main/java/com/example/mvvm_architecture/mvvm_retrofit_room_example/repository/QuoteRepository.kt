package com.example.mvvm_architecture.mvvm_retrofit_room_example.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_architecture.mvvm_retrofit_room_example.api.QuoteService
import com.example.mvvm_architecture.mvvm_retrofit_room_example.model.QuoteList

class QuoteRepository(private val quoteService: QuoteService) {

    private val quotesLivaData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get() = quotesLivaData

    suspend fun getQuotes(page: Int) {
        val result = quoteService.getQuotes(page)
        if (result?.body() != null){
            quotesLivaData.postValue(result.body())
        }
    }
}