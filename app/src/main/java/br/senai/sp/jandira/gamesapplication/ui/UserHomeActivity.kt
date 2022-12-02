package br.senai.sp.jandira.gamesapplication.ui

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.adapters.GamesAdapter
import br.senai.sp.jandira.gamesapplication.dao.UserDAO
import br.senai.sp.jandira.gamesapplication.databinding.ActivityGameRegisterBinding
//import br.senai.sp.jandira.gamesapplication.dao.GamesDAO
import br.senai.sp.jandira.gamesapplication.databinding.ActivityUserHomeBinding
import br.senai.sp.jandira.gamesapplication.models.User
import br.senai.sp.jandira.gamesapplication.repository.ConsoleRepository
import br.senai.sp.jandira.gamesapplication.repository.UserRepository
import java.util.*

class UserHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserHomeBinding
    private lateinit var adapterGames : GamesAdapter
    private lateinit var userRepository: UserRepository
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.title = "Games"
        supportActionBar?.setBackgroundDrawable(ColorDrawable(
            ContextCompat.getColor(this, R.color.purple_700)
        ))
        supportActionBar?.elevation = 0F

        userRepository = UserRepository(this)
        val id = intent.getIntExtra("user_id", 0)
        user = userRepository.getUserById(id)

        getDataFromUser(user)

        binding.rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapterGames = GamesAdapter(this)
        binding.rvGames.adapter = adapterGames

    }

    private fun getDataFromUser(user: User) {
        binding.editNameUser.setText(user.nome)
        binding.editEmailUser.setText(user.email)
        binding.editGameLevel.setText(user.nivel.nivel)
        binding.textAge.setText((Calendar.getInstance().get(Calendar.YEAR).toInt() - user.dataNascimento.split("/").last().toInt()).toString());
        var countFinalizado = 0
        var countPlaying = 0

        userRepository.getUserGamesById(user.user_id)[0].games.forEach {
            if (it.finalizado) {
                countFinalizado += 1
            } else {
                countPlaying += 1
            }
        }

        Toast.makeText(this, "${userRepository.getUserGamesById(user.user_id)[0].games}", Toast.LENGTH_SHORT).show()
        binding.textGamesFinished.setText(countFinalizado.toString())
        binding.textGamesPlaying.setText(countPlaying.toString())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add_game) {
            if (item.itemId == R.id.menu_add_game) {
                val intentRegisterGame = Intent(this, GameRegisterActivity::class.java)
                intentRegisterGame.putExtra("user_id", user.user_id)
                startActivity(intentRegisterGame)
                return true
            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater

        inflater.inflate(R.menu.menu_user_home, menu)

        return true
    }

    override fun onResume() {
        super.onResume()
        getDataFromUser(user)
        adapterGames.updateGamesList(userRepository.getUserGamesById(user.user_id)[0].games)
    }
}