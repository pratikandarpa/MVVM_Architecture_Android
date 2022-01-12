package com.example.mvvm_architecture.mvvm_retrofit_room_example.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_architecture.mvvm_retrofit_room_example.api.QuoteService
import com.example.mvvm_architecture.mvvm_retrofit_room_example.db.QuoteDatabase
import com.example.mvvm_architecture.mvvm_retrofit_room_example.model.QuoteList
import com.example.mvvm_architecture.mvvm_retrofit_room_example.utils.NetworkUtils

class QuoteRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quotesLivaData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get() = quotesLivaData

    suspend fun getQuotes(page: Int) {

        if (NetworkUtils.isNetworkAvailable(applicationContext)) {
            val result = quoteService.getQuotes(page)
            if (result?.body() != null) {
                quoteDatabase.quoteDao().insertQuotes(result.body()!!.results)
                quotesLivaData.postValue(result.body())
            }
        } else {
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1, 1, 1, quotes, 1, 1)
            quotesLivaData.postValue(quoteList)
        }
    }
}