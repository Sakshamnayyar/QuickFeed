package com.saksham.quickfeed.data.repository

import android.util.Log
import com.saksham.quickfeed.data.local.ArticleDao
import com.saksham.quickfeed.data.local.ArticleEntity
import com.saksham.quickfeed.data.mapper.toEntity
import com.saksham.quickfeed.data.network.GNewsApiService
import com.saksham.quickfeed.domain.model.Post
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.saksham.quickfeed.domain.mapper.toPost
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Singleton
class NewsFeedRepository @Inject constructor(
    private val newsApiService: GNewsApiService,
    private val articleDao: ArticleDao
){
    suspend fun refreshArticles() {
        try {
            val response = newsApiService.getTopHeadLines()
            val articles = response.listOfArticles.map { it.toEntity() }
            withContext(Dispatchers.IO) {
                articleDao.clearArticles()
                articleDao.insertArticles(articles)
            }
        } catch (e: Exception) {
            // Handle error
            Log.e("NewsFeedRepository", "Error fetching top headlines: ${e.message}")
        }
    }
    fun getCachedArticles(): Flow<List<Post>> =
        articleDao.getAllArticles().map { list -> list.map { it.toPost() } }
}