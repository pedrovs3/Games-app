package br.senai.sp.jandira.gamesapplication.database

import android.content.Context
import androidx.room.*
import br.senai.sp.jandira.gamesapplication.dao.ConsoleDAO
import br.senai.sp.jandira.gamesapplication.dao.GamesDAO
import br.senai.sp.jandira.gamesapplication.dao.UserDAO
import br.senai.sp.jandira.gamesapplication.models.Console
import br.senai.sp.jandira.gamesapplication.models.Game
import br.senai.sp.jandira.gamesapplication.models.User
import br.senai.sp.jandira.gamesapplication.repository.ConsoleRepository

@Database(entities = [User::class, Console::class, Game::class], version = 1)
abstract class GamesBd : RoomDatabase() {
    abstract fun userDAO(): UserDAO
    abstract fun consoleDAO(): ConsoleDAO
    abstract fun gameDAO(): GamesDAO

    companion object{
        private lateinit var instance : GamesBd

        private fun registerConsole (context: Context) {
            ConsoleRepository(context).save(Console("Xbox series X","Microsoft", "Console desenvolvido pela microsoft lançado no ano de 2020", null, 2020 ))
            ConsoleRepository(context).save(Console("Nintendo","Nintendo", "Console desenvolvido pela nintendo lançado no ano de 2020", null, 2020 ))
            ConsoleRepository(context).save(Console("Playstation 5","Sony", "Console desenvolvido pela sony lançado no ano de 2020", null, 2020 ))
        }

        fun getDatabase(context: Context) : GamesBd {

            if (!Companion::instance.isInitialized) {
                instance = Room.databaseBuilder(context, GamesBd::class.java, "db_games").allowMainThreadQueries().build()
                if(ConsoleRepository(context).getAll().isEmpty()) {
                    registerConsole(context)
                }
            }


            return instance
        }
    }
}