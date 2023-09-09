package com.abdul.bhaiya.tweets.di

import com.abdul.bhaiya.tweets.api.TweetsAPI
import com.abdul.bhaiya.tweets.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//step5: create a network module

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideTweetsAPI(retrofit: Retrofit) : TweetsAPI{
        return retrofit.create(TweetsAPI::class.java)
    }
}