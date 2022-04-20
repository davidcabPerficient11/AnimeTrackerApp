package com.example.animetrackerapp.framework.networklayer

import com.example.animetrackerapp.domain.model.Anime
import com.example.animetrackerapp.utils.TOP_ANIME_URL
import retrofit2.Response
import retrofit2.http.GET

interface JikanApiClient {

    @GET(TOP_ANIME_URL)
    suspend fun getAnimeListByTopRated(): Response<Anime>
}