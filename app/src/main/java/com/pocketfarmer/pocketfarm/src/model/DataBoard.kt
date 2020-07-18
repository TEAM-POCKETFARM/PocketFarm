package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataBoard(
    @SerializedName("boardIdx")
    val boardIdx: Int,
    @SerializedName("boardImg")
    val boardImg: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("likeNum")
    val likeNum: Int,
    @SerializedName("price1")
    val price1: String,
    @SerializedName("tag")
    val tag: String,
    @SerializedName("title")
    val title: String
): Serializable