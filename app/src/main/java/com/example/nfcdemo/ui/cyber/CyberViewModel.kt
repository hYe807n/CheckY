package com.example.nfcdemo.ui.cyber

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CyberViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is cyber Fragment"
    }
    val text: LiveData<String> = _text
}