package br.senai.sp.jandira.gamesapplication.dao

import android.content.Context
import androidx.room.*
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.models.Game

@Dao
interface GamesDAO {
    @Query("SELECT * FROM tbl_game ORDER BY titulo DESC")
    fun getAll():List<Game>

    @Query("SELECT * FROM tbl_game WHERE game_id = :id")
    fun getById(id: Int) : Game

    @Update
    fun updateGame(game: Game): Int

    @Delete
    fun deleteGame(game: Game): Int

    @Insert
    fun insertGame(game: Game): Long
}