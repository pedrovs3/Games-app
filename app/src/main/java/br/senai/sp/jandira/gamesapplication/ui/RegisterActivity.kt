package br.senai.sp.jandira.gamesapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.Toast
import br.senai.sp.jandira.gamesapplication.R
import br.senai.sp.jandira.gamesapplication.databinding.ActivityRegisterBinding
import br.senai.sp.jandira.gamesapplication.models.enums.NiveisEnum
import br.senai.sp.jandira.gamesapplication.models.User
import br.senai.sp.jandira.gamesapplication.repository.UserRepository

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)

        setContentView(binding.root)
        supportActionBar?.title = "Register"
        supportActionBar?.elevation = 0F

        userRepository = UserRepository(this)

        val binding.spinnerConsole

        binding.sliderLevel.addOnChangeListener { slider, value, fromUser ->
            binding.textViewLevelLabel.text = gameLevel(value.toInt())!!.nivel
        }
    }

    private fun gameLevel(value: Int): NiveisEnum {
        if (value == 1) {
            return NiveisEnum.INICIANTE
        }
        if (value == 2) {
            return NiveisEnum.BASICO
        }
        if (value == 3) {
            return NiveisEnum.CASUAL
        }
        if (value == 4) {
            return NiveisEnum.AVANCADO
        }
        return NiveisEnum.TRYHARD
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_save) {
            var user = getFormData()
            val id = userRepository.save(user)

            Toast.makeText(this, "salvo, id: ${id}", Toast.LENGTH_SHORT).show()
            return true
        }

        return true
    }

    private fun getFormData(): User {
        val email = binding.editEmail.text.toString()
        val password = binding.editPassword.text.toString()
        val name = binding.editName.text.toString()
        val city = binding.editCity.text.toString()
        val birthdate = binding.editBirthdate.text.toString()

        val nivel = gameLevel(binding.sliderLevel.value.toInt())
        var idSelected = binding.radioGroup.checkedRadioButtonId

        val sexo = findViewById<RadioButton>(idSelected).text.toString()[0]

        val user = User(
            email,
            null,  // imagem
            password,
            name,
            city,
            nivel,
            sexo,
            birthdate,
            null
        )

        return user
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater

        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }


}