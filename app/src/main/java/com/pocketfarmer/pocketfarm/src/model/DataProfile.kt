package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class DataProfile(
    @SerializedName("name")
    val name: String,
    @SerializedName("userImg")
    val userImg: String
)