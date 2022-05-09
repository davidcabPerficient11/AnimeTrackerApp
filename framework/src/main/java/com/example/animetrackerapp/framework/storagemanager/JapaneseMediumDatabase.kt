package com.example.animetrackerapp.framework.storagemanager

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.animetrackerapp.framework.storagemanager.daos.TopAnimeDao
import com.example.animetrackerapp.framework.storagemanager.entities.TopAnimeEntity

@Database(entities = [TopAnimeEntity::class], version = 1, exportSchema = false)

abstract class JapaneseMediumDatabase : RoomDatabase() {

    abstract fun getTopAnimeDao(): TopAnimeDao

    companion object {

        @Volatile
        private var INSTANCE: JapaneseMediumDatabase? = null

        fun getDatabase(context: Context): JapaneseMediumDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JapaneseMediumDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}