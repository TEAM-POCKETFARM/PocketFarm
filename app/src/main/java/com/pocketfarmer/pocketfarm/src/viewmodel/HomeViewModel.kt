package com.pocketfarmer.pocketfarm.src.viewmodel

import android.app.Application
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pocketfarmer.pocketfarm.NetworkHelper
import com.pocketfarmer.pocketfarm.src.activity.DetailActivity
import com.pocketfarmer.pocketfarm.src.model.BoardResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(application: Application) : AndroidViewModel(application){
    var contents = getContentsList()

    private fun getContentsList(): LiveData<List<BoardResponseData>>{
        val contents: MutableLiveData<List<BoardResponseData>> = MutableLiveData()

        val result = NetworkHelper.getInstance().getService().getBoardAll()
        result.enqueue(object: Callback<List<BoardResponseData>> {
            override fun onFailure(call: Call<List<BoardResponseData>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<BoardResponseData>>,
                response: Response<List<BoardResponseData>>
            ) {
                when(response.code()){
                    200 -> contents.value = response.body()
                }
            }
        })

        return contents
    }

    fun navigeTo(activity: Class<DetailActivity>){
        getApplication<Application>().startActivity(Intent(getApplication<Application>().baseContext, activity)
            .apply { flags = FLAG_ACTIVITY_NEW_TASK })
    }
}