package com.saksham.quickfeed.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val title: String,
    val description: String? = null,
    val content: String? = null,
    val url: String,
    val image: String? = null,
    val publishedAt: String,
    val source: NewsSource
)
