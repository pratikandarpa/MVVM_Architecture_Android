package com.example.databindingroom.dataBindingC

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databindingroom.R
import com.example.databindingroom.dataModel.Qutos
import com.example.databindingroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

//        mainViewModel.quotsLiveData.observe(this, Observer {
//            binding.tvHello.text = it
//        })

//        binding.lifecycleOwner = this
//        binding.mainViewModel = mainViewModel


        val post = Qutos("HelloBBB",
                "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png")
        binding.mainViewModel = post
    }
}