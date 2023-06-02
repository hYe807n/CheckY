package com.example.nfcdemo.ui.jongjung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JongjungViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is timetable Fragment"
    }
    val text: LiveData<String> = _text
}