package com.example.animetrackerapp.framework.storagemanager.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.animetrackerapp.framework.storagemanager.entities.TopAnimeEntity

@Dao
interface TopAnimeDao {

    @Query("SELECT * FROM top_anime WHERE id = :id")
    suspend fun findTopAnime(id: Int): TopAnimeEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(topAnimeEntity: TopAnimeEntity)

    //replace with update
    /* @Query("SELECT * FROM top_anime WHERE id = :id")
     suspend fun updateTopAnimeFavorites()*/

    @Query("DELETE FROM top_anime WHERE id = :id")
    suspend fun deleteById(id: Int)

}