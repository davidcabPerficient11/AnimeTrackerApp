package com.example.animetrackerapp.di

import com.example.animetrackerapp.data.datasource.RemoteDataSource
import com.example.animetrackerapp.data.repositories.JikanRepositoryImpl
import com.example.animetrackerapp.data.usecases.GetAnimeUseCaseImpl
import com.example.animetrackerapp.domain.repositories.JikanRepository
import com.example.animetrackerapp.domain.usecases.GetAnimeUseCase
import com.example.animetrackerapp.framework.network.JikanApiClient
import com.example.animetrackerapp.framework.network.JikanApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideGetAnimeUseCase(jikanRepository: JikanRepository): GetAnimeUseCase {
        return GetAnimeUseCaseImpl(jikanRepository)
    }

    @Provides
    fun provideJikanRepository(remoteDataSource: RemoteDataSource): JikanRepository {
        return JikanRepositoryImpl(remoteDataSource)
    }

    @Provides
    fun provideRemoteDataSource(jikanApiClient: JikanApiClient): RemoteDataSource {
        return JikanApiService(jikanApiClient)
    }
}