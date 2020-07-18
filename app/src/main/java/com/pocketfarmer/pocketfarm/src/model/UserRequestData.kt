package com.pocketfarmer.pocketfarm.src.model

import com.google.gson.annotations.SerializedName

data class UserRequestData (
    @SerializedName("userId")
    var userId: String,
    @SerializedName("password")
    var password: String
)
