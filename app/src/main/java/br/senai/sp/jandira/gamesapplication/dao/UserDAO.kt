package br.senai.sp.jandira.gamesapplication.dao

import androidx.room.*
import br.senai.sp.jandira.gamesapplication.models.User

@Dao
interface UserDAO {
    @Query("SELECT * FROM tbl_user ORDER BY nome DESC")
    fun getAllUser(): List<User>

    @Query("SELECT * FROM tbl_user WHERE id = :id")
    fun getUserById(id: Int) : User

    @Update
    fun updateUser(user: User): Int

    @Insert
    fun insertUser(user: User): Long

    @Delete
    fun deleteUser(user: User):Int
}