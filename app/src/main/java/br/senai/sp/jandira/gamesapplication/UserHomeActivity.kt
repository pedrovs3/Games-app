package br.senai.sp.jandira.gamesapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class UserHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)

        supportActionBar?.title = "Games"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater

        inflater.inflate(R.menu.menu_user_home, menu)

        return true
    }
}