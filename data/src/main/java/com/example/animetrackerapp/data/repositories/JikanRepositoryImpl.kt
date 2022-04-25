package com.example.animetrackerapp.data.repositories

import com.example.animetrackerapp.data.datasource.RemoteDataSource
import com.example.animetrackerapp.domain.entities.Anime
import com.example.animetrackerapp.domain.repositories.JikanRepository

class JikanRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : JikanRepository {

    override suspend fun getTopAnimeList(): Anime? {
        return remoteDataSource.getTopAnimeList()
    }
}