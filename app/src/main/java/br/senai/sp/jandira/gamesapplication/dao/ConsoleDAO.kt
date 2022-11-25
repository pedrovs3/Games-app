package br.senai.sp.jandira.gamesapplication.dao

import androidx.room.*
import br.senai.sp.jandira.gamesapplication.models.Console
import br.senai.sp.jandira.gamesapplication.models.User

@Dao
interface ConsoleDAO {
    @Query("SELECT * FROM tbl_console ORDER BY nome_console DESC")
    fun getAllConsole(): List<Console>

    @Query("SELECT * FROM tbl_console WHERE id_console = :id")
    fun getConsoleById(id: Int) : Console

    @Update
    fun updateConsole(console: Console): Int

    @Insert
    fun insertConsole(console: Console): Long

    @Delete
    fun deleteConsole(console: Console):Int
}