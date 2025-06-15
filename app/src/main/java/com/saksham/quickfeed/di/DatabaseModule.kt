package com.saksham.quickfeed.di

import android.content.Context
import androidx.room.Room
import com.saksham.quickfeed.data.local.ArticleDao
import com.saksham.quickfeed.data.local.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ArticleDatabase =
        Room.databaseBuilder(
            appContext,
            ArticleDatabase::class.java,
            "article_db"
        ).build()

    @Provides
    @Singleton
    fun provideDao(database: ArticleDatabase): ArticleDao = database.dao
}