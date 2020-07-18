package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class UserResponseData(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int
){
    override fun toString(): String {
        return "UserResponseData(`data`=$`data`, message='$message', statusCode=$statusCode)"
    }
}