package com.example.animetrackerapp.framework.storagemanager.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "top_anime")
data class TopAnimeEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "end_date")
    var endDate: String,
    var episodes: Int,
    @ColumnInfo(name = "image_url")
    var imageUrl: String,
    var rank: Int,
    var score: Double,
    @ColumnInfo(name = "start_date")
    var startDate: String,
    var title: String,
    var type: String,
    var url: String
)


