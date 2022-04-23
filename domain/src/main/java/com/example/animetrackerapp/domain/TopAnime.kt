package com.example.animetrackerapp.domain

data class TopAnime(
    val end_date: String,
    val episodes: Int,
    val image_url: String,
    val rank: Int,
    val score: Double,
    val start_date: String,
    val title: String,
    val type: String,
    val url: String
)