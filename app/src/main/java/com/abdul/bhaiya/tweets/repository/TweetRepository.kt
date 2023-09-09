package com.abdul.bhaiya.tweets.repository

import com.abdul.bhaiya.tweets.api.TweetsAPI
import com.abdul.bhaiya.tweets.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

//step6: create a repository

class TweetRepository @Inject constructor(private val tweetsAPI: TweetsAPI) {

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets: StateFlow<List<TweetListItem>>
        get() = _tweets

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories

    suspend fun getTweets(category:String) {
        val result = tweetsAPI.getTweets("tweets[?(@.category==\"$category\")]")
        if (result.isSuccessful && result.body() != null) {
            _tweets.emit(result.body()!!)
        }
    }

    suspend fun getCategories() {
        val result = tweetsAPI.getCategories()
        if (result.isSuccessful && result.body() != null) {
            _categories.emit(result.body()!!)
        }
    }
}