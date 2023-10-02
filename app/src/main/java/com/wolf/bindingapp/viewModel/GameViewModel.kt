package com.wolf.bindingapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wolf.bindingapp.model.Game
import com.wolf.bindingapp.model.GamesProvider

class GameViewModel : ViewModel() {

    val gameModel = MutableLiveData<Game>()

    fun getRandomGame() {
        val currentGame = GamesProvider.random()
        gameModel.postValue(currentGame)
    }
}