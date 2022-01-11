package com.example.mvvm_architecture.mvvm_retrofit_room_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_architecture.R
import com.example.mvvm_architecture.mvvm_retrofit_room_example.api.QuoteService
import com.example.mvvm_architecture.mvvm_retrofit_room_example.api.RetrofitHelper
import com.example.mvvm_architecture.mvvm_retrofit_room_example.repository.QuoteRepository
import com.example.mvvm_architecture.mvvm_retrofit_room_example.viewmodels.MainViewModel
import com.example.mvvm_architecture.mvvm_retrofit_room_example.viewmodels.MainViewModelFactory

class MvvmRetrofitRoomActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_retrofit_room)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuoteRepository(quoteService)

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Log.i("DataData", it.results.toString())
        })
    }
}