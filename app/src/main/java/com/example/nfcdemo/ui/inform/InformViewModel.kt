package com.example.nfcdemo.ui.inform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InformViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is inform Fragment"
    }
    val text: LiveData<String> = _text
}