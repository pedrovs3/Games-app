package br.senai.sp.jandira.gamesapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.databinding.ActivityGameRegisterBinding
import br.senai.sp.jandira.gamesapplication.models.Game
import br.senai.sp.jandira.gamesapplication.models.User
import br.senai.sp.jandira.gamesapplication.repository.GameRepository
import br.senai.sp.jandira.gamesapplication.repository.UserRepository

class GameRegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityGameRegisterBinding
    private lateinit var user: User
    private lateinit var gameRepository: GameRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gameRepository = GameRepository(this)

        supportActionBar!!.elevation = 0F

        val user_id = intent.getIntExtra("user_id", 0)
        user = UserRepository(this).getUserById(user_id)

    }

    private fun getFormData(): Game {
        val produtora = binding.editProdutora.text.toString()
        val nomeJogo = binding.editNomeJogo.text.toString()
        val description = binding.editDescription.text.toString()
        val launch_year = binding.editYear.text.toString().toInt()

        var finished = false
        if(binding.gameFinalized.isChecked) {
            finished = true
        }

        val created_by = user.user_id

        val game = Game(nomeJogo,
        description,
        produtora,
        launch_year,
        finished,
        created_by,
        null
        )

        return game
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_save) {
            val game = gameRepository.save(getFormData())
            Toast.makeText(this, "${game}", Toast.LENGTH_SHORT).show()

            finish()
            return true
        }

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater

        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }
}