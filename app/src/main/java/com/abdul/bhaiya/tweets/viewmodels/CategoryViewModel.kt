package com.abdul.bhaiya.tweets.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdul.bhaiya.tweets.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//step7: create a category view model

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: TweetRepository) : ViewModel() {

    val categories: StateFlow<List<String>>
        get() = repository.categories

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }
}