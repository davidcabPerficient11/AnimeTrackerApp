package com.example.animetrackerapp.di

import com.example.animetrackerapp.data.datasources.LocalDataSource
import com.example.animetrackerapp.data.datasources.RemoteDataSource
import com.example.animetrackerapp.data.repositories.AnimeRepositoryImpl
import com.example.animetrackerapp.data.usecases.GetAnimeUseCaseImpl
import com.example.animetrackerapp.domain.repositories.AnimeRepository
import com.example.animetrackerapp.domain.usecases.GetAnimeUseCase
import com.example.animetrackerapp.framework.datasourcesimpl.LocalDataSourceImpl
import com.example.animetrackerapp.framework.network.ApiClient
import com.example.animetrackerapp.framework.datasourcesimpl.RemoteDataSourceImpl
import com.example.animetrackerapp.framework.storagemanager.daos.TopAnimeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideGetAnimeUseCase(jikanRepository: AnimeRepository): GetAnimeUseCase {
        return GetAnimeUseCaseImpl(jikanRepository)
    }

    @Provides
    fun provideJikanRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): AnimeRepository {
        return AnimeRepositoryImpl(remoteDataSource, localDataSource)
    }

    @Provides
    fun provideRemoteDataSource(jikanApiClient: ApiClient): RemoteDataSource {
        return RemoteDataSourceImpl(jikanApiClient)
    }

    @Provides
    fun provideLocalDataSource(topAnimeDao: TopAnimeDao): LocalDataSource {
        return LocalDataSourceImpl(topAnimeDao)
    }
}