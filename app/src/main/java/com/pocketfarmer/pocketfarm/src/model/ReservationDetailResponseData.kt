package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class ReservationDetailResponseData(
    @SerializedName("data")
    val `data`: List<DataReservationDetail>,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int
)