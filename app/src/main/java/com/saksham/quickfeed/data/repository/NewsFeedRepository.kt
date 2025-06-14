package com.saksham.quickfeed.data.repository

import com.saksham.quickfeed.data.network.GNewsApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsFeedRepository @Inject constructor(
    private val newsApiService: GNewsApiService
){

}