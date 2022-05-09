package com.example.animetrackerapp.framework.datasourcesimpl

import com.example.animetrackerapp.data.datasources.LocalDataSource
import com.example.animetrackerapp.framework.storagemanager.daos.TopAnimeDao
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val topAnimeDao: TopAnimeDao
) : LocalDataSource {

    override suspend fun saveAnime() {
        TODO("Not yet implemented")
    }

    override suspend fun getTopAnimeList() {
        TODO("Not yet implemented")
    }

    override suspend fun findAnimeById() {
        TODO("Not yet implemented")
    }

    override suspend fun updateAnime() {
        TODO("Not yet implemented")
    }
}