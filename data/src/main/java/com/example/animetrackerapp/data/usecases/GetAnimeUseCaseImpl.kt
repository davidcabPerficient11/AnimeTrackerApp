package com.example.animetrackerapp.data.usecases

import com.example.animetrackerapp.domain.model.Anime
import com.example.animetrackerapp.domain.repositories.AnimeRepository
import com.example.animetrackerapp.domain.usecases.GetAnimeUseCase

class GetAnimeUseCaseImpl(private val repository: AnimeRepository) : GetAnimeUseCase {

    override suspend fun getTopAnimeList(): Anime? {
        return repository.getTopAnimeList()
    }
}