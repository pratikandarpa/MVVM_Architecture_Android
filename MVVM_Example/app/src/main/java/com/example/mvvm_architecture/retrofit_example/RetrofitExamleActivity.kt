package com.example.mvvm_architecture.retrofit_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvvm_architecture.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RetrofitExamleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_examle)

        val quoteAPI = RetrofitHelper.getInstance().create(QuoteAPI::class.java)
        GlobalScope.launch {
            val result = quoteAPI.getQuotes(1)
            if (result != null) {
                Log.i("DataData", result.body().toString())
            }
        }
    }
}