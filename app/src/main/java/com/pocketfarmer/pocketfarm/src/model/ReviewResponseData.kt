package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class ReviewResponseData(
    @SerializedName("data")
    val `data`: List<DataReview>,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int
)