package br.senai.sp.jandira.gamesapplication.repository

import android.content.Context
import br.senai.sp.jandira.gamesapplication.database.GamesBd
import br.senai.sp.jandira.gamesapplication.models.Game

class GameRepository(context: Context) {
    private val db = GamesBd.getDatabase(context).gameDAO()

    fun save(game: Game) :Long {
        return db.insertGame(game)
    }
}