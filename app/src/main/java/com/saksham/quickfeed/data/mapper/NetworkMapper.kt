package com.saksham.quickfeed.data.mapper

import com.saksham.quickfeed.data.local.ArticleEntity
import com.saksham.quickfeed.data.model.Article
import com.saksham.quickfeed.data.model.NewsSource

fun Article.toEntity(): ArticleEntity = ArticleEntity(
    url = url,
    title = title,
    description = description,
    content = content,
    image = image,
    publishedAt = publishedAt,
    sourceName = source.name,
    sourceUrl = source.url
)

fun ArticleEntity.toArticle(): Article = Article(
    title = title,
    description = description,
    content = content,
    url = url,
    image = image,
    publishedAt = publishedAt,
    source = NewsSource(
        name = sourceName,
        url = sourceUrl
    )
)
