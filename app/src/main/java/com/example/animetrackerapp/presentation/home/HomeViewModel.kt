package com.example.animetrackerapp.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animetrackerapp.domain.entities.Anime
import com.example.animetrackerapp.framework.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val topAnimeList = MutableLiveData<Anime>()

    fun retrieveAnimeList() {
        viewModelScope.launch(Dispatchers.IO) {
            val jikanApiService = RetrofitHelper.provideJikanService()
            val response = jikanApiService.getAnimeListByTopRated()
            if (response.isSuccessful)
                topAnimeList.postValue(response.body())
        }
    }
}