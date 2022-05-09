package com.example.animetrackerapp.data.datasources

import com.example.animetrackerapp.domain.model.Anime

interface RemoteDataSource {

    suspend fun getTopAnimeList(): Anime?

}