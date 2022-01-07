package com.example.databindingroom.dataBindingC

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val quotsLiveData = MutableLiveData("Mr.Andarpa")

    fun updateQutos(){
        quotsLiveData.value = "Mr. Pratik"
    }
}