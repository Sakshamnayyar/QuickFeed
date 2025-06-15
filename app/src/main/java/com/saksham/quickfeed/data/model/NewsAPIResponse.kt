package com.saksham.quickfeed.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsAPIResponse(
    val totalArticles: Int,

    @SerialName("articles")
    val listOfArticles: List<Article>
)
