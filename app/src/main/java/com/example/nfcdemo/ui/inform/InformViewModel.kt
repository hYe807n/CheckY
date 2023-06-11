package com.example.nfcdemo.ui.inform

import android.annotation.SuppressLint
import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nfcdemo.MainActivity
import com.example.nfcdemo.R
import com.example.nfcdemo.databinding.ActivityLoginBinding
import com.example.nfcdemo.ui.login.LoggedInUserView

class InformViewModel : ViewModel() {

    private val _name = MutableLiveData<String>().apply {
        value = "This is timetable Fragment"
    }

    private val _id = MutableLiveData<String>().apply {
        value = "This is sdfsdf Fragment"
//
////    private val _profile = MutableLiveData<Int>().apply {
////        value = R.drawable.profile
////    }
//    val profile: LiveData<Int> = _profile
    }
    val name: LiveData<String> = _name
    val id: LiveData<String> = _id
}