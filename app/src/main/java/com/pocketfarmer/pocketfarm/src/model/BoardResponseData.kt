package com.pocketfarmer.pocketfarm.src.model

import com.google.gson.annotations.SerializedName

data class BoardResponseData (
    @SerializedName("boardIdx")
    var boardIdx: Int,
    @SerializedName("boardImg")
    var boardImg: String,
    @SerializedName("category")
    var category: String,
    @SerializedName("tag")
    var tag: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("minPrice")
    var minPrice: Int,
    @SerializedName("likeNum")
    var likeNum: Int
)
