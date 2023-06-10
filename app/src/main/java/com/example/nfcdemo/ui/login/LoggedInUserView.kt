package com.example.nfcdemo.ui.login

import android.widget.ImageView

/**
 * User details post authentication that is exposed to the UI
 */
data class LoggedInUserView(
    val displayName: String,
    val id : String
    //... other data fields that may be accessible to the UI
)