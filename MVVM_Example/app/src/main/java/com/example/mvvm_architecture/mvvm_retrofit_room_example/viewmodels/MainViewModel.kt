package com.example.mvvm_architecture.mvvm_retrofit_room_example.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_architecture.mvvm_retrofit_room_example.model.QuoteList
import com.example.mvvm_architecture.mvvm_retrofit_room_example.repository.QuoteRepository
import com.example.mvvm_architecture.mvvm_retrofit_room_example.repository.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.getQuotes(1)
        }
    }

    val quotes: LiveData<Response<QuoteList>>
    get() = quoteRepository.quotes
}