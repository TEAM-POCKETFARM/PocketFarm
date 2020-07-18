package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class DataProduct(
    @SerializedName("goodsContent")
    val goodsContent: String,
    @SerializedName("goodsImg")
    val goodsImg: String
)