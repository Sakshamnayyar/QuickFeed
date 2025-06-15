package com.saksham.quickfeed.domain.model

data class Post(
    val title: String,
    val description: String?,
    val content: String?,
    val image: String?,
    val publishedAt: String,
    val sourceName: String,
    val url: String
)
