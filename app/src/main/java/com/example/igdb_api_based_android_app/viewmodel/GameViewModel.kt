
package com.example.igdb_api_based_android_app.viewmodel

import androidx.lifecycle.*
import com.example.igdb_api_based_android_app.model.GameResponse
import com.example.igdb_api_based_android_app.repository.GameRepository
import kotlinx.coroutines.launch

class GameViewModel(private val repository: GameRepository) : ViewModel() {
    private val _games = MutableLiveData<List<GameResponse>>()
    val games: LiveData<List<GameResponse>> = _games

    fun loadGames() {
        viewModelScope.launch {
            _games.value = repository.fetchGames()
        }
    }
}