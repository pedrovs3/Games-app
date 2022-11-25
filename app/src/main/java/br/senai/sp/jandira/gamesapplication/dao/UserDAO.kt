package br.senai.sp.jandira.gamesapplication.dao

import androidx.room.*
import br.senai.sp.jandira.gamesapplication.models.User
import br.senai.sp.jandira.gamesapplication.models.User_Game

@Dao
interface UserDAO {
    @Transaction
    @Query("SELECT * FROM tbl_user WHERE user_id = :id")
    fun getUserWithGames(id: Int) : List<User_Game>

    @Query("SELECT * FROM tbl_user ORDER BY nome DESC")
    fun getAllUser(): List<User>

    @Query("SELECT * FROM tbl_user WHERE email = :email")
    fun getUserByEmail(email: String): User

    @Query("SELECT * FROM tbl_user WHERE user_id = :id")
    fun getUserById(id: Int) : User

    @Update
    fun updateUser(user: User): Int

    @Insert
    fun insertUser(user: User): Long

    @Delete
    fun deleteUser(user: User):Int
}