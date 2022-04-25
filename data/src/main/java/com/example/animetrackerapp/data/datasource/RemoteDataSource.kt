package com.example.animetrackerapp.data.datasource

import com.example.animetrackerapp.domain.entities.Anime

interface RemoteDataSource {

    suspend fun getTopAnimeList(): Anime?

}