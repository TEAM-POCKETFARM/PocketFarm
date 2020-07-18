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
import com.pocketfarmer.pocketfarm.src.model.DataBoard
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(application: Application) : AndroidViewModel(application){
    var contents = getContentsList()

    private fun getContentsList(): LiveData<List<DataBoard>>{
        val contents: MutableLiveData<List<DataBoard>> = MutableLiveData()

        val result = NetworkHelper.getInstance().getService().getBoardAll()
        result.enqueue(object: Callback<BoardResponseData> {
            override fun onFailure(call: Call<BoardResponseData>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<BoardResponseData>,
                response: Response<BoardResponseData>
            ) {
                val boardList : BoardResponseData = response.body() ?: return
                contents.value = boardList.data
            }
        })

        return contents
    }

    fun navigateTo(activity: Class<DetailActivity>, board: DataBoard){
        getApplication<Application>().startActivity(Intent(getApplication<Application>().baseContext, activity)
            .apply {
                flags = FLAG_ACTIVITY_NEW_TASK
                putExtra("data", board)
            })
    }
}