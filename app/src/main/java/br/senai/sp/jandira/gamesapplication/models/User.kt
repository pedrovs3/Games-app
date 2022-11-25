package br.senai.sp.jandira.gamesapplication.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.senai.sp.jandira.gamesapplication.models.enums.NiveisEnum

@Entity(tableName = "tbl_user")
data class User (
    val email:String,
    val user_foto: ByteArray?,
    val senha:String,
    val nome:String,
    val cidade:String,
    val nivel: NiveisEnum,
    val sexo:Char,
    @ColumnInfo(name = "data_nascimento") val dataNascimento:String,
    @Embedded val console: Console?
) {
    @PrimaryKey(autoGenerate = true) var user_id:Int = 0
}