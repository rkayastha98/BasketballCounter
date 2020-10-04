package com.bignerdranch.android.basketballcounter

import androidx.lifecycle.ViewModel
import java.util.*

class GameListViewModel : ViewModel() {
    val games = mutableListOf<Game>()

    init {
        for (i in 0 until 100) {
            val game = Game()
            game.date = Date()
            game.teamA ="Team A"
            game.teamB="Team B"
            game.AScore=0
            game.BScore=0
            games += games
        }
    }
}