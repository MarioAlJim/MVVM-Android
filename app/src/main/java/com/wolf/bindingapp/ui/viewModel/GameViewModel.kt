package com.wolf.bindingapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wolf.bindingapp.data.model.Game
import com.wolf.bindingapp.data.model.GameProvider
import com.wolf.bindingapp.domain.GetGamesUseCase
import com.wolf.bindingapp.domain.GetRandomGameUseCase
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    val gameModel = MutableLiveData<Game>()
    val showLoader = MutableLiveData<Boolean>()

    var getGamesUseCase = GetGamesUseCase()
    var gatRandomGameUseCase = GetRandomGameUseCase()

    fun onCreate() {
        viewModelScope.launch {
            showLoader.postValue(true)
            val result = getGamesUseCase()

            if (!result.isNullOrEmpty()) {
                gameModel.postValue(result[0])
                showLoader.postValue(false)
            }
        }
    }

    fun getRandomGame() {
        showLoader.postValue(true)
        val game = gatRandomGameUseCase()
        game.let {
            gameModel.postValue(it)
        }
        showLoader.postValue(false)
    }
}