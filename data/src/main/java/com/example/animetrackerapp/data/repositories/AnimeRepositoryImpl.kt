package com.example.animetrackerapp.data.repositories

import com.example.animetrackerapp.data.datasources.LocalDataSource
import com.example.animetrackerapp.data.datasources.RemoteDataSource
import com.example.animetrackerapp.domain.model.Anime
import com.example.animetrackerapp.domain.repositories.AnimeRepository

class AnimeRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : AnimeRepository {

    override suspend fun getTopAnimeList(): Anime? {
        return remoteDataSource.getTopAnimeList()
    }
}