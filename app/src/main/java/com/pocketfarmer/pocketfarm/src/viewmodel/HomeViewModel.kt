package com.pocketfarmer.pocketfarm.src.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pocketfarmer.pocketfarm.src.model.Content

class HomeViewModel: ViewModel(){
    var contents = getContentsList()

    private fun getContentsList(): LiveData<List<Content>>{
        val contents = MutableLiveData<List<Content>>()
        val list = arrayListOf<Content>()
        for(i in 0..2){
            list.add(Content("title$i"))
        }
        contents.value = list
        return contents
    }
}