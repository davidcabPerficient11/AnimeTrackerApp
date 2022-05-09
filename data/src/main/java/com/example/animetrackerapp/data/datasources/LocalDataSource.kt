package com.example.animetrackerapp.data.datasources

interface LocalDataSource {

    suspend fun saveAnime()

    suspend fun getTopAnimeList()

    suspend fun findAnimeById()

    suspend fun updateAnime()
}