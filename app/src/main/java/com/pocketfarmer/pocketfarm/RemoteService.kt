package com.pocketfarmer.pocketfarm

import com.pocketfarmer.pocketfarm.src.model.*
import retrofit2.Call
import retrofit2.http.*

interface RemoteService {
    @Headers("Content-type:application/json")
    @POST("user/signin")
    fun loginService(@Body userRequestData: UserRequestData) : Call<UserResponseData>
    
    @GET("board/boardAll")
    fun getBoardAll():Call<BoardResponseData>

    @GET("home/donations")
    fun getDonation():Call<DonationResponseData>

    @GET("board/{boardIdx}")
    fun getBoardDetail(@Path("boardIdx")boardIdx:Int):Call<BoardDetailResponseData>
}