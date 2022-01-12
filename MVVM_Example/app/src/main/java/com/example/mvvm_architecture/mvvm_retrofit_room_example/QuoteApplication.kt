package com.example.mvvm_architecture.mvvm_retrofit_room_example

import android.app.Application
import com.example.mvvm_architecture.mvvm_retrofit_room_example.api.QuoteService
import com.example.mvvm_architecture.mvvm_retrofit_room_example.api.RetrofitHelper
import com.example.mvvm_architecture.mvvm_retrofit_room_example.db.QuoteDatabase
import com.example.mvvm_architecture.mvvm_retrofit_room_example.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}