package com.pocketfarmer.pocketfarm

import com.pocketfarmer.pocketfarm.src.model.BoardResponseData
import com.pocketfarmer.pocketfarm.src.model.UserRequestData
import com.pocketfarmer.pocketfarm.src.model.UserResponseData
import retrofit2.Call
import retrofit2.http.*

interface RemoteService {
    @Headers("Content-type:application/json")
    @POST("user/signin")
    fun loginService(@Body userRequestData: UserRequestData) : Call<UserResponseData>
    
    @GET("board/boardAll")
    fun getBoardAll():Call<List<BoardResponseData>>
}