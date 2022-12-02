package br.senai.sp.jandira.gamesapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import br.senai.sp.jandira.gamesapplication.databinding.ActivityMainBinding
import br.senai.sp.jandira.gamesapplication.models.Console
import br.senai.sp.jandira.gamesapplication.models.User
import br.senai.sp.jandira.gamesapplication.repository.ConsoleRepository
import br.senai.sp.jandira.gamesapplication.repository.UserRepository

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var userRepository: UserRepository
    lateinit var consoleRepository: ConsoleRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRepository = UserRepository(this)

        consoleRepository = ConsoleRepository(this)
        supportActionBar!!.hide()

        binding.editCreateAccount.setOnClickListener {
            val openRegisterActivity = Intent(this, RegisterActivity::class.java)
            startActivity(openRegisterActivity)
        }

        binding.rememberMe.setOnClickListener {

        }

        binding.buttonLogin.setOnClickListener {
            val user = userRepository.getUserByEmail(binding.editEmail.text.toString())

            if (validation()) {
                val openUserHomeActivity = Intent(this, UserHomeActivity::class.java)
                openUserHomeActivity.putExtra("user_id", user.user_id)

                startActivity(openUserHomeActivity)
            }

        }
    }

    private fun validation():Boolean {
        val userEmailInput = binding.editEmail.text.toString()
        val user = userRepository.getUserByEmail(userEmailInput)

        if(binding.editEmail.text.isEmpty()) {
            binding.editEmail.error = "Insira um email!"
            return false
        }
        if(binding.editPassword.text.isEmpty()) {
            binding.editPassword.error = "A senha é requirida!"
            return false
        }

        if(user === null) {
            Toast.makeText(this, "Email ou senha incorreto. $user", Toast.LENGTH_SHORT).show()
            return false
        } else if (user.senha != binding.editPassword.text.toString()) {
            Toast.makeText(this, "Email ou senha incorreto.  $user", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}