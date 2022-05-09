package com.example.animetrackerapp.framework.network

import com.example.animetrackerapp.domain.model.Anime
import com.example.animetrackerapp.framework.utils.TOP_ANIME_URL
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET(TOP_ANIME_URL)
    suspend fun getAnimeListByTopRated(): Response<Anime>
}