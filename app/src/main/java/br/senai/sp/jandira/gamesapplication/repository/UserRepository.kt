package br.senai.sp.jandira.gamesapplication.repository

import android.content.Context
import br.senai.sp.jandira.gamesapplication.dao.GamesBd
import br.senai.sp.jandira.gamesapplication.models.User

class UserRepository(context: Context) {
    private val db = GamesBd.getDatabase(context).userDAO()

    fun save(user: User): Long {
        return db.insertUser(user)
    }

    fun getAll():List<User> {
        return db.getAllUser()
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