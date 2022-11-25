package br.senai.sp.jandira.gamesapplication.models

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_console")
data class Console (
    var nome_console:String,
    var fabricante :String,
    var descricao: String,
    var console_foto:ByteArray? = null,
    var anoLancamento:Int? = null
) {
    @PrimaryKey(autoGenerate = true) var id_console: Int = 0
}