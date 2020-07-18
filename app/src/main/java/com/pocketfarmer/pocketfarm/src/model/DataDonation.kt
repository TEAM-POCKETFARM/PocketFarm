package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataDonation(
    @SerializedName("archiveRate")
    val archiveRate: Int,
    @SerializedName("currentPrice")
    val currentPrice: String,
    @SerializedName("goalPrice")
    val goalPrice: String
): Serializable