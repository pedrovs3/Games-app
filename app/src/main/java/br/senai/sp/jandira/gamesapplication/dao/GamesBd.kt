package br.senai.sp.jandira.gamesapplication.dao

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import br.senai.sp.jandira.gamesapplication.models.Console
import br.senai.sp.jandira.gamesapplication.models.Game
import br.senai.sp.jandira.gamesapplication.models.User

@Database(entities = [User::class, Console::class, Game::class], version = 1)
abstract class GamesBd : RoomDatabase() {
    abstract fun userDAO(): UserDAO

    companion object{
        private lateinit var instance : GamesBd

        fun getDatabase(context: Context) :GamesBd {
            if (!::instance.isInitialized) {
                instance = Room.databaseBuilder(context, GamesBd::class.java, "db_games").allowMainThreadQueries().build()
            }
            return instance
        }
    }
}