package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class DataReview(
    @SerializedName("averageScore")
    val averageScore: Double,
    @SerializedName("nickname")
    val nickname: String,
    @SerializedName("reviewContent")
    val reviewContent: String,
    @SerializedName("reviewIdx")
    val reviewIdx: Int,
    @SerializedName("reviewImg")
    val reviewImg: String,
    @SerializedName("starScore")
    val starScore: Double,
    @SerializedName("userId")
    val userId: String
)