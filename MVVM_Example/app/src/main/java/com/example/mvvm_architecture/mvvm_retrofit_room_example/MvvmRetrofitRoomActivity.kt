package com.example.mvvm_architecture.mvvm_retrofit_room_example

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_architecture.R
import com.example.mvvm_architecture.mvvm_retrofit_room_example.api.QuoteService
import com.example.mvvm_architecture.mvvm_retrofit_room_example.api.RetrofitHelper
import com.example.mvvm_architecture.mvvm_retrofit_room_example.repository.QuoteRepository
import com.example.mvvm_architecture.mvvm_retrofit_room_example.repository.Response
import com.example.mvvm_architecture.mvvm_retrofit_room_example.viewmodels.MainViewModel
import com.example.mvvm_architecture.mvvm_retrofit_room_example.viewmodels.MainViewModelFactory

class MvvmRetrofitRoomActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_retrofit_room)

        val pvLoading = findViewById<ProgressBar>(R.id.pvLoading)
        val repository = (application as QuoteApplication).quoteRepository

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            when (it) {
                is Response.Loading -> {
                    pvLoading.visibility = View.VISIBLE
                    //Show the Loading Or Loading Code.
                }
                is Response.Success -> {
                    pvLoading.visibility = View.INVISIBLE
                    it.data?.let {
                        Log.i("DataData", it.results.toString())
                        Toast.makeText(
                            this@MvvmRetrofitRoomActivity,
                            it.results.size.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                is Response.Error -> {
                    pvLoading.visibility = View.INVISIBLE
                    it.errorMessage.let {
                        Toast.makeText(
                            this@MvvmRetrofitRoomActivity,
                            "Something went wrong",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })
    }
}