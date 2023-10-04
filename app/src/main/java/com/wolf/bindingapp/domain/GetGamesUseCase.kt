package com.wolf.bindingapp.domain

import com.wolf.bindingapp.data.GameRepository
import com.wolf.bindingapp.data.model.Game

class GetGamesUseCase {
    private val repository = GameRepository()

    suspend operator fun invoke(): List<Game>? = repository.getAllGames()
}