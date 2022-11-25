package br.senai.sp.jandira.gamesapplication.repository

import android.content.Context
import br.senai.sp.jandira.gamesapplication.database.GamesBd
import br.senai.sp.jandira.gamesapplication.models.Console

class ConsoleRepository(context: Context) {
    private val db = GamesBd.getDatabase(context).consoleDAO()

    fun save(console: Console) :Long {
        return db.insertConsole(console)
    }

    fun getAll() :List<Console> {
        return db.getAllConsole()
    }
}