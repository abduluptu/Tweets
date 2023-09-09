package com.abdul.bhaiya.tweets.api

import com.abdul.bhaiya.tweets.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

//step3: create api interface

interface TweetsAPI {

    @GET("/v3/b/64b3dd858e4aa6225ebf1315?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String) : Response<List<TweetListItem>>
    //added dynamic @Header

    @GET("/v3/b/64b3dd858e4aa6225ebf1315?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(): Response<List<String>>
    //added static @Headers
}