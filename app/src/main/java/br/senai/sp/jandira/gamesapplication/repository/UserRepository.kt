package br.senai.sp.jandira.gamesapplication.repository

import android.content.Context
import br.senai.sp.jandira.gamesapplication.database.GamesBd
import br.senai.sp.jandira.gamesapplication.models.User
import br.senai.sp.jandira.gamesapplication.models.User_Game

class UserRepository(context: Context) {
    private val db = GamesBd.getDatabase(context).userDAO()

    fun save(user: User): Long {
        return db.insertUser(user)
    }

    fun getUserGamesById(id: Int): List<User_Game> {
        return db.getUserWithGames(id)
    }

    fun getAll():List<User> {
        return db.getAllUser()
    }

    fun getUserByEmail(email: String) : User{
        return db.getUserByEmail(email)
    }

    fun getUserById(id:Int) : User {
        return db.getUserById(id)
    }

    fun update(user: User): Int {
        return db.updateUser(user)
    }

    fun delete(user: User):Int {
        return db.deleteUser(user)
    }
}