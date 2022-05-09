package com.example.animetrackerapp.domain.model

data class TopAnime(
    val endDate: String,
    val episodes: Int,
    val imageUrl: String,
    val rank: Int,
    val score: Double,
    val startDate: String,
    val title: String,
    val type: String,
    val url: String
)