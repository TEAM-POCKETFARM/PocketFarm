package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class DonationResponseData(
    @SerializedName("data")
    val `data`: DataDonation,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int
)