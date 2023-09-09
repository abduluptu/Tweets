package com.abdul.bhaiya.tweets.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdul.bhaiya.tweets.models.TweetListItem
import com.abdul.bhaiya.tweets.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//step8: create a detail items view model

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: TweetRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() { //Note: when we navigate from one screen to other arguments are saved in SavedStateHandle

    val tweets: StateFlow<List<TweetListItem>>
        get() = repository.tweets

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "motivation"
            repository.getTweets(category)
        }
    }
}