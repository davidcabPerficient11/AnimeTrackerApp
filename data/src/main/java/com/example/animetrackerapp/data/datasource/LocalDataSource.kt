package com.example.animetrackerapp.data.datasource

interface LocalDataSource {

    suspend fun saveAnime()

    suspend fun getTopAnimeList()

    suspend fun findAnimeById()

    suspend fun updateAnime()
}