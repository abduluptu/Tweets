package com.abdul.bhaiya.tweets.data.network

import com.abdul.bhaiya.tweets.data.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

//step3: create api interface

interface TweetsAPI {

    @GET("/v3/b/668cedb4e41b4d34e40f40b2?meta=false")
    @Headers("X-Bin-Meta: false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetListItem>>
    //added dynamic @Header

    @GET("/v3/b/668cedb4e41b4d34e40f40b2?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>
    //added static @Headers
}