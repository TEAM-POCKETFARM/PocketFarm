package com.pocketfarmer.pocketfarm.src.model


import com.google.gson.annotations.SerializedName

data class DataBoardDetail(
    @SerializedName("amount1")
    val amount1: String,
    @SerializedName("amount2")
    val amount2: String,
    @SerializedName("amount3")
    val amount3: String,
    @SerializedName("boardImg")
    val boardImg: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("currentAmount")
    val currentAmount: Int,
    @SerializedName("deliverDate")
    val deliverDate: String,
    @SerializedName("goalAmount")
    val goalAmount: Int,
    @SerializedName("period")
    val period: String,
    @SerializedName("price1")
    val price1: String,
    @SerializedName("price2")
    val price2: String,
    @SerializedName("price3")
    val price3: String,
    @SerializedName("tag")
    val tag: String,
    @SerializedName("title")
    val title: String
)