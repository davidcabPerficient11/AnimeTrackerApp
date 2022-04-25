package com.example.animetrackerapp.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animetrackerapp.domain.entities.Anime
import com.example.animetrackerapp.domain.usecases.GetAnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAnimeUseCase: GetAnimeUseCase
) : ViewModel() {

    val topAnimeList = MutableLiveData<Anime>()
    val isLoading = MutableLiveData<Boolean>()

    fun retrieveAnimeList() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = getAnimeUseCase.getTopAnimeList()
            if (response != null) {
                topAnimeList.postValue(response!!)
                isLoading.postValue(false)
            }
        }
    }
}