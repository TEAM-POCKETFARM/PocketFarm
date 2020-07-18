package com.pocketfarmer.pocketfarm.src.viewmodel

import android.app.Application
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pocketfarmer.pocketfarm.NetworkHelper
import com.pocketfarmer.pocketfarm.src.activity.MainActivity
import com.pocketfarmer.pocketfarm.src.activity.SignInActivity
import com.pocketfarmer.pocketfarm.src.base.BaseActivity
import com.pocketfarmer.pocketfarm.src.model.UserRequestData
import com.pocketfarmer.pocketfarm.src.model.UserResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInViewModel(application: Application) : AndroidViewModel(application) {
    var userId: String = ""
    var password: String = ""

    var responseData: MutableLiveData<UserResponseData> = MutableLiveData()


    fun login() {
        val userRequestData = UserRequestData(userId, password)

        val result = NetworkHelper.getInstance().getService().loginService(userRequestData)
        result.enqueue(object : Callback<UserResponseData> {
            override fun onFailure(call: Call<UserResponseData>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<UserResponseData>,
                response: Response<UserResponseData>
            ) {
                val userResponseData = response.body() ?: UserResponseData(null, "로그인 실패", 400)
                responseData.value = userResponseData

                Log.d("userResponseData", userResponseData.toString())
            }
        })
    }
}