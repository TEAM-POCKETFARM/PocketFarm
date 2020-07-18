package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class ProductResponseData(
    @SerializedName("data")
    val dataProduct: DataProduct,
    @SerializedName("message")
    val message: String,
    @SerializedName("statusCode")
    val statusCode: Int
)