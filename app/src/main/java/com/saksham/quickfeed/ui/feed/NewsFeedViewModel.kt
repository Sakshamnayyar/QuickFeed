package com.saksham.quickfeed.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saksham.quickfeed.data.local.ArticleEntity
import com.saksham.quickfeed.data.repository.NewsFeedRepository
import com.saksham.quickfeed.domain.model.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsFeedViewModel @Inject constructor(
    private val newsFeedRepository: NewsFeedRepository
): ViewModel() {

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    val posts: StateFlow<List<Post>> = newsFeedRepository
        .getCachedArticles()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        refreshArticles()
    }

    fun refreshArticles() {
        viewModelScope.launch {
            _isRefreshing.value = true
            newsFeedRepository.refreshArticles()
            _isRefreshing.value = false
        }
    }

}