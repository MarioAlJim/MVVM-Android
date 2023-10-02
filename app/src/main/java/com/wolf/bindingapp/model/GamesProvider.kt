package com.wolf.bindingapp.model

class GamesProvider {
    companion object {
        fun random(): Game {
            val randomIndex = (0..3).random()
            return games[randomIndex]
        }

        private val games = listOf<Game>(
            Game("Halo Infinite", "343 Industries", "haloinf"),
            Game("Call of Duty MW2", "Activision", "mw2"),
            Game("Resident Ivol 4", "Capcom", "resident4"),
            Game("Destiny 2", "Bungie", "destiny2")
        )
    }
}