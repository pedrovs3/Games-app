package br.senai.sp.jandira.gamesapplication.models

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_user")
data class User (
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    var foto:Bitmap? = null,
    var email:String,
    var senha:String,
    var nome:String,
    var cidade:String,
    var nivel:NiveisEnum,
    var sexo:Char,
    @ColumnInfo(name = "data_nascimento") var dataNascimento:String,
    @Embedded var console:Console?
)