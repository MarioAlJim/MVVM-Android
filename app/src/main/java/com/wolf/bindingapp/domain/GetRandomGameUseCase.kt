package com.wolf.bindingapp.domain

import com.wolf.bindingapp.data.GameRepository
import com.wolf.bindingapp.data.model.Game
import com.wolf.bindingapp.data.model.GameProvider

class GetRandomGameUseCase {
    private val repository = GameRepository()

    operator fun invoke(): Game? {
        val games = GameProvider.games
        if (!games.isNullOrEmpty()) {
            val randomNumber = (games.indices).random()
            return games[randomNumber]
        }

        return null
    }
}