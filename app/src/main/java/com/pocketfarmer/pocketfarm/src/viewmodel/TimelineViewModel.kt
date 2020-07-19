package com.pocketfarmer.pocketfarm.src.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.pocketfarmer.pocketfarm.src.model.DataTimeline

class TimelineViewModel(application: Application) : AndroidViewModel(application){
    val timeline = arrayListOf<DataTimeline>()
}