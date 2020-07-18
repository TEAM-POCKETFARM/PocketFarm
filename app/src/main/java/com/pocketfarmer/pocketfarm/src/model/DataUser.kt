package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class DataUser(
    @SerializedName("name")
    val name: String,
    @SerializedName("userIdx")
    val userIdx: Int
)