package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class DataFarm(
    @SerializedName("description")
    val description: String,
    @SerializedName("farmContent")
    val farmContent: String,
    @SerializedName("farmImg")
    val farmImg: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("userImg")
    val userImg: String
)