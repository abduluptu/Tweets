package com.abdul.bhaiya.tweets.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdul.bhaiya.tweets.data.repositories.TweetRepository
import com.abdul.bhaiya.tweets.utils.isInternetAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//step7: create a category view model

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: TweetRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    val categories: StateFlow<List<String>>
        get() = repository.categories

    // For network check
    private val _networkError = MutableStateFlow<String?>(null)
    val networkError: StateFlow<String?> get() = _networkError

    init {
        viewModelScope.launch {
            if (context.isInternetAvailable()) {
                try {
                    repository.getCategories()
                } catch (e: Exception) {
                    // Handle error during network call
                    _networkError.value = "Failed to fetch categories: ${e.message}"
                }
            } else {
                // Handle no internet scenario
                _networkError.value = "No internet connection"
            }
        }
    }
}