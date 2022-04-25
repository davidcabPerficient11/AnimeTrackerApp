package com.example.animetrackerapp.domain.repositories

import com.example.animetrackerapp.domain.entities.Anime

interface JikanRepository {

    suspend fun getTopAnimeList(): Anime?
}