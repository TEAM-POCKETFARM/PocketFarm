package com.pocketfarmer.pocketfarm.src.model

import com.google.gson.annotations.SerializedName

data class ReservationRequestData (
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("price")
    val price: String,
    @SerializedName("ea")
    val ea: Int,
    @SerializedName("donatePoint")
    val donatePoint: String,
    @SerializedName("baeminPoint")
    val baeminPoint: String
)
