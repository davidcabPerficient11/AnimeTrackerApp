package com.example.animetrackerapp.domain.usecases

import com.example.animetrackerapp.domain.entities.Anime

interface GetAnimeUseCase {

    suspend fun getTopAnimeList(): Anime?
}