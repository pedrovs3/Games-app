package br.senai.sp.jandira.gamesapplication.dao

import android.content.Context
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.models.Game

@Dao
interface GamesDAO {
    @Query("SELECT * FROM tbl_game ORDER BY titulo DESC")
    fun getAll():List<Game>

    @Query("SELECT * FROM tbl_game WHERE id = :id")
    fun getById(id: Int) : Game

    @Insert
    fun insertGame(game: Game): Int
}