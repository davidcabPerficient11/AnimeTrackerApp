package com.example.animetrackerapp.framework.network

import com.example.animetrackerapp.data.datasource.RemoteDataSource
import com.example.animetrackerapp.domain.entities.Anime
import javax.inject.Inject

class JikanApiService @Inject constructor(
    private val jikanApiClient: JikanApiClient
) : RemoteDataSource {

    override suspend fun getTopAnimeList(): Anime? {
        val response = jikanApiClient.getAnimeListByTopRated()

        return response.body()
    }
}