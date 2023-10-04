package com.wolf.bindingapp.data.model

import com.google.gson.annotations.SerializedName

data class Game (
    val name: String,
    val developmentStudio: String,

    @SerializedName("gameImage")
    val gameImage: String
)