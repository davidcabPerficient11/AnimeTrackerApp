package com.example.animetrackerapp.data.usecases

import com.example.animetrackerapp.domain.entities.Anime
import com.example.animetrackerapp.domain.repositories.JikanRepository
import com.example.animetrackerapp.domain.usecases.GetAnimeUseCase

class GetAnimeUseCaseImpl(private val repository: JikanRepository) : GetAnimeUseCase {

    override suspend fun getTopAnimeList(): Anime? {
        return repository.getTopAnimeList()
    }
}