package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class BoardResponseData(
    @SerializedName("data")
    val `data`: List<DataBoard>,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int
)