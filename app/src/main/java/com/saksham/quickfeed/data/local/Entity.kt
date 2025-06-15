package com.saksham.quickfeed.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String? = null,
    val content: String? = null,
    val image: String? = null,
    val publishedAt: String,
    val sourceName: String,
    val sourceUrl: String,
    val url: String,
) {
}