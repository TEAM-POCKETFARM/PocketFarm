package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class BoardDetailResponseData(
    @SerializedName("data")
    val dataBoardDetail: DataBoardDetail,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int
)