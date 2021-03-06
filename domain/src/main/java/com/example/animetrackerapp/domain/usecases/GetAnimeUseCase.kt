package com.example.animetrackerapp.domain.usecases

import com.example.animetrackerapp.domain.model.Anime

interface GetAnimeUseCase {

    suspend fun getTopAnimeList(): Anime?
}