package com.saksham.quickfeed.data.network

import com.saksham.quickfeed.data.model.NewsAPIResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GNewsApiService {
    @GET("search")
    suspend fun getNewsByTopic(
        @Query("q")topic: String,
        @Query("lang") language: String = "en",
        @Query("max") max: Int = 10
    ): NewsAPIResponse

    @GET("top-headlines")
    suspend fun getTopHeadLines(
        @Query("category") category: String = "general",
        @Query("lang") language: String = "en",
        @Query("max") max: Int = 10
    ): NewsAPIResponse

}