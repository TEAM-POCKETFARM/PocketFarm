package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class FarmResponseData(
    @SerializedName("data")
    val dataFarm: DataFarm,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int
)