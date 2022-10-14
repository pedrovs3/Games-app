package br.senai.sp.jandira.gamesapplication

import android.graphics.drawable.ColorDrawable
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.senai.sp.jandira.gamesapplication.adapters.GamesAdapter
import br.senai.sp.jandira.gamesapplication.dao.GamesDAO
import br.senai.sp.jandira.gamesapplication.databinding.ActivityUserHomeBinding
import br.senai.sp.jandira.gamesapplication.models.Game

class UserHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserHomeBinding
    private lateinit var adapterGames : GamesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.title = "Games"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(
            ContextCompat.getColor(this, R.color.purple_700)
        ))
        supportActionBar?.elevation = 0F

        binding.rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapterGames = GamesAdapter(this)
        adapterGames.updateGamesList(GamesDAO.getGamesRegistered(this))

        binding.rvGames.adapter = adapterGames

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater

        inflater.inflate(R.menu.menu_user_home, menu)

        return true
    }
}