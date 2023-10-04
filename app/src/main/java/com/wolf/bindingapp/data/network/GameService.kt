package com.wolf.bindingapp.data.network

import com.wolf.bindingapp.core.RetrofitHelper
import com.wolf.bindingapp.data.model.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getGames(): List<Game> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(GameApiClient::class.java).getAllGames()
            response.body() ?: emptyList()
        }
    }
}