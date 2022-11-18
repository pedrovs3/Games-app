package br.senai.sp.jandira.gamesapplication.models

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_game")
data class Game (
    var titulo:String,
    var descricao:String,
    var estudio:String,
    var anoLancamento:Int,
    var finalizado:Boolean,
//    var imagem :Bitmap?
    ) {
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}