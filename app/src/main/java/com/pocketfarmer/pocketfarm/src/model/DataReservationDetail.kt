package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class DataReservationDetail(
    @SerializedName("date")
    val date: String,
    @SerializedName("tlContent")
    val tlContent: String,
    @SerializedName("tlIdx")
    val tlIdx: Int,
    @SerializedName("tlImg")
    val tlImg: String
)