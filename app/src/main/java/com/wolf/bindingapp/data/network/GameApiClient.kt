package com.wolf.bindingapp.data.network

import com.wolf.bindingapp.data.model.Game
import retrofit2.Response
import retrofit2.http.GET

interface GameApiClient {
    @GET("0efff7f2-abfa-4d21-ba24-4d92d8053a91")
    suspend fun getAllGames(): Response<List<Game>>
}