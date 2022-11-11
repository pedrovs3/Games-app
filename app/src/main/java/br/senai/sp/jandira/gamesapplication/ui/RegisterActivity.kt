package br.senai.sp.jandira.gamesapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.databinding.ActivityRegisterBinding
import br.senai.sp.jandira.gamesapplication.models.Console
import br.senai.sp.jandira.gamesapplication.models.NiveisEnum
import br.senai.sp.jandira.gamesapplication.models.User
import br.senai.sp.jandira.gamesapplication.repository.UserRepository
import java.time.LocalDate

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)
        supportActionBar?.title = "Register"
        supportActionBar?.elevation = 0F

        binding.sliderLevel.addOnChangeListener { slider, value, fromUser ->
        binding.textViewLevelLabel.text = gameLevel(value.toInt());
        }
    }

    private fun gameLevel(value: Int): String? {
        if (value == 1) {
            return "Iniciante"
        }
        if (value == 2) {
            return "Básico"
        }
        if (value == 3) {
            return "Casual"
        }
        if (value == 4) {
            return "Avançado"
        }
        return "Iniciante"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_save) {
            var user = getFormData()
            Toast.makeText(this, "salvo", Toast.LENGTH_SHORT).show()
            return true
        } else if (item.itemId == R.id.menu_settings) {
            Toast.makeText(this, "Configuraçao", Toast.LENGTH_SHORT).show()
            return true
        } else {
            Toast.makeText(this, "sair", Toast.LENGTH_SHORT).show()
            return true
        }

        return true
    }

    private fun getFormData() {
        val email = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()
        val name = binding.editName.text.toString()
        val city = binding.editCity.text.toString()
        val birthdate = binding.editBirthdate.text.toString()

        var nivel = NiveisEnum.INICIANTE
        if (binding.sliderLevel.value.toInt() == 1) {
            NiveisEnum.INICIANTE
        } else if (binding.sliderLevel.value.toInt() == 2) {
            NiveisEnum.BASICO
        } else if (binding.sliderLevel.value.toInt() == 3) {
            NiveisEnum.CASUAL
        } else {
            NiveisEnum.AVANCADO
        }

        val sexo = 'F'

        val user = User(
            0,
//            null,
            email,
            password,
            name,
            city,
            nivel,
            sexo,
            birthdate,
            null
        )

        userRepository = UserRepository(this)
        userRepository.save(user)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater

        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }


}