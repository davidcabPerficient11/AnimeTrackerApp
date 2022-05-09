package com.example.animetrackerapp.framework.datasourcesimpl

import com.example.animetrackerapp.data.datasources.RemoteDataSource
import com.example.animetrackerapp.domain.model.Anime
import com.example.animetrackerapp.framework.network.ApiClient
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiClient: ApiClient
) : RemoteDataSource {

    override suspend fun getTopAnimeList(): Anime? {
        val response = apiClient.getAnimeListByTopRated()
        return response.body()
    }
}