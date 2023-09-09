package com.abdul.bhaiya.tweets.models


import com.google.gson.annotations.SerializedName

//step2: create tweet model class


data class TweetListItem(
    @SerializedName("category")
    val category: String,
    @SerializedName("text")
    val text: String
)
