package com.wolf.bindingapp.data

import com.wolf.bindingapp.data.model.Game
import com.wolf.bindingapp.data.model.GameProvider
import com.wolf.bindingapp.data.network.GameService

class GameRepository {

    private val api = GameService()

    suspend fun getAllGames(): List<Game> {
        val response = api.getGames()
        GameProvider.games = response
        return response
    }

}