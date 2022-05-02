package com.example.animetrackerapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Named("IO")
    @Provides
    fun provideCoroutineScopeIO(): CoroutineDispatcher = Dispatchers.IO

    @Named("Main")
    @Provides
    fun provideCoroutineScopeMain(): CoroutineDispatcher = Dispatchers.Main
}