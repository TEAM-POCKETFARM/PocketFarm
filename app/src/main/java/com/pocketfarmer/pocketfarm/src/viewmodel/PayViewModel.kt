package com.pocketfarmer.pocketfarm.src.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import java.text.DecimalFormat

class PayViewModel(application: Application) : AndroidViewModel(application) {

    fun setReword(price: Int, percent: Double): String = DecimalFormat("###,###")
            .format((price * percent).toInt()).toString()
}