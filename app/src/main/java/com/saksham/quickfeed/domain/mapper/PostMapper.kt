package com.saksham.quickfeed.domain.mapper

import com.saksham.quickfeed.data.local.ArticleEntity
import com.saksham.quickfeed.data.model.Article
import com.saksham.quickfeed.domain.model.Post

fun Article.toPost(): Post = Post(
    title = title,
    description = description,
    content = content,
    image = image,
    publishedAt = publishedAt,
    sourceName = source.name,
    url = url
)

fun ArticleEntity.toPost(): Post = Post(
    title = title,
    description = description,
    content = content,
    image = image,
    publishedAt = publishedAt,
    sourceName = sourceName,
    url = url
)

