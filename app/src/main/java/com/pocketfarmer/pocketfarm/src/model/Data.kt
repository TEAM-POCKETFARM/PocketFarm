package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("name")
    val name: String,
    @SerializedName("userIdx")
    val userIdx: Int
)