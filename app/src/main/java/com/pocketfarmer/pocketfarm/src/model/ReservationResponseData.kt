package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class ReservationResponseData(
    @SerializedName("data")
    val `data`: List<DataReservation>,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int
)