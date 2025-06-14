package com.saksham.quickfeed.data.model

import kotlinx.serialization.Serializable

@Serializable
data class NewsAPIResponse(
    val totalArticles: Int,
    val listOfNews: List<Article>
)
