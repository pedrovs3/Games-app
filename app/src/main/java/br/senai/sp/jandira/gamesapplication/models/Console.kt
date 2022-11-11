package br.senai.sp.jandira.gamesapplication.models

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_console")
data class Console(
    @PrimaryKey(autoGenerate = true) var codigo:Int,
    var nome:String,
    var fabricante :String,
    var descricao: String,
    var foto:Bitmap? = null,
    var anoLancamento:Int
)