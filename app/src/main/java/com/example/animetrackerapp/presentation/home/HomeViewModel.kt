package com.example.animetrackerapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animetrackerapp.domain.entities.TopAnime
import com.example.animetrackerapp.domain.usecases.GetAnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAnimeUseCase: GetAnimeUseCase,
    @param:Named("IO") private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _topAnimeList = MutableLiveData<List<TopAnime>>()
    val topAnimeList: LiveData<List<TopAnime>> get() = _topAnimeList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun retrieveAnimeList() {
        viewModelScope.launch(dispatcher) {
            val response = getAnimeUseCase.getTopAnimeList()

            response?.let { result ->
                _topAnimeList.postValue(result.top)
                _isLoading.postValue(false)
            }
        }
    }
}