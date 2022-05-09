package com.example.animetrackerapp.domain.repositories

import com.example.animetrackerapp.domain.model.Anime

interface AnimeRepository {

    suspend fun getTopAnimeList(): Anime?
}