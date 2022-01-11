package com.example.mvvm_architecture.mvvm_retrofit_room_example.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_architecture.mvvm_retrofit_room_example.repository.QuoteRepository

class MainViewModelFactory(private val quoteRepository: QuoteRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quoteRepository) as T
    }
}