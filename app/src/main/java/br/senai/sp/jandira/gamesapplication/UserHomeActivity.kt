package br.senai.sp.jandira.gamesapplication

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.content.ContextCompat

class UserHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)

        supportActionBar?.title = "Games"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(
            ContextCompat.getColor(this, R.color.purple_700)
        ))
        supportActionBar?.elevation = 0F
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater

        inflater.inflate(R.menu.menu_user_home, menu)

        return true
    }
}