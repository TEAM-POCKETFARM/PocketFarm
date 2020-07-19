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

    @GET("board/goods/{boardIdx}")
    fun getProduct(@Path("boardIdx")boardIdx:Int):Call<ProductResponseData>

    @GET("board/farm/{boardIdx}")
    fun getFarm(@Path("boardIdx")boardIdx:Int):Call<FarmResponseData>

    @Headers("Content-Type: application/json")
    @POST("board/reserve/boardIdx/{boardIdx}/userIdx/{userIdx}")
    fun postReservation(@Path("boardIdx")boardIdx:Int, @Path("userIdx")userIdx:Int,
        @Body reservationRequestData: ReservationRequestData):Call<String>

    @GET("board/review/{boardIdx}")
    fun getReviewList(@Path("boardIdx")boardIdx:Int):Call<ReviewResponseData>

    @GET("mypage/{userIdx}")
    fun getProfile(@Path("userIdx")userIdx:Int):Call<ProfileResponseData>

    @GET("mypage/reservationAll/{userIdx}")
    fun getReservation(@Path("userIdx")userIdx:Int):Call<ReservationResponseData>

    @GET("mypage/tl/{boardIdx}")
    fun getReservationDetail(@Path("boardIdx")boardIdx:Int):Call<ReservationDetailResponseData>
}