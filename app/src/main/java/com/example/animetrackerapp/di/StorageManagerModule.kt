package com.example.animetrackerapp.di

import android.content.Context
import androidx.room.Room
import com.example.animetrackerapp.framework.storagemanager.JapaneseMediumDatabase
import com.example.animetrackerapp.framework.storagemanager.daos.TopAnimeDao
import com.example.animetrackerapp.framework.utils.JAPANESE_MEDIUM_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageManagerModule {


    @Singleton
    @Provides
    fun provideLocalDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, JapaneseMediumDatabase::class.java,
        JAPANESE_MEDIUM_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideTopAnimeDao(database: JapaneseMediumDatabase): TopAnimeDao =
        database.getTopAnimeDao()
}