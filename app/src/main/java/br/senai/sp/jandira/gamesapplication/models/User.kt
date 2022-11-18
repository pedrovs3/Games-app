package br.senai.sp.jandira.gamesapplication.models

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_user")
data class User (
    val email:String,
    val senha:String,
    val nome:String,
    val cidade:String,
    val nivel:NiveisEnum,
    val sexo:Char,
    @ColumnInfo(name = "data_nascimento") val dataNascimento:String,
    @Embedded val console: Console?
) {
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}