package com.pocketfarmer.pocketfarm.src.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.pocketfarmer.pocketfarm.R

class MainViewModel(application: Application) : AndroidViewModel(application){
    var mainTitle: MutableLiveData<String> = MutableLiveData()

    fun setTitle(fragment: Int){
        var title = ""
        when(fragment){
            R.id.fg_home
                -> title = getApplication<Application>().resources.getStringArray(R.array.title)[0]
            R.id.fg_category
                -> title = getApplication<Application>().resources.getStringArray(R.array.title)[1]
            R.id.fg_my_farm
                -> title = getApplication<Application>().resources.getStringArray(R.array.title)[2]
        }
        mainTitle.value = title
    }
}