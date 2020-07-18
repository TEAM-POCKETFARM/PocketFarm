package com.pocketfarmer.pocketfarm

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkHelper {

    private val builder = OkHttpClient.Builder()
    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor(object: HttpLoggingInterceptor.Logger{
            override fun log(message: String) {
                android.util.Log.d("RetrofitDebug", message)
            }
        }).apply { level = HttpLoggingInterceptor.Level.BODY  } // Retrofit 에서 통신 과정의 로그를 확인하기 위함. 로그의 level 을 지정
        builder.addInterceptor(httpLoggingInterceptor)
    }
    private val okHttpClient = builder.build()

    companion object{
        private var networkHelper:NetworkHelper = NetworkHelper()

        fun getInstance():NetworkHelper{
            return networkHelper
        }
    }

    private val retrofit = Retrofit.Builder().client(okHttpClient).baseUrl("http://13.209.112.246:3000/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val remoteService:RemoteService = retrofit.create(RemoteService::class.java)

    fun getService():RemoteService{
        return remoteService
    }
}