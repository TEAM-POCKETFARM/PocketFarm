package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataReservation(
    @SerializedName("boardIdx")
    val boardIdx: Int,
    @SerializedName("boardImg")
    val boardImg: String,
    @SerializedName("progressRate")
    val progressRate: Int,
    @SerializedName("remainPeriod")
    val remainPeriod: Int,
    @SerializedName("reserveIdx")
    val reserveIdx: Int,
    @SerializedName("title")
    val title: String
): Serializable