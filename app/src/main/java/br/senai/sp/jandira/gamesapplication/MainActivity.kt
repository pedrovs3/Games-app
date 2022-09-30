package br.senai.sp.jandira.gamesapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.gamesapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.buttonLogin.setOnClickListener {
            if (validation()) {
                val openRegister = Intent(this, RegisterActivity::class.java)

                startActivity(openRegister)
            }
        }
    }

    private fun validation():Boolean {
        if(binding.editEmail.text.isEmpty()) {
            binding.editEmail.error = "Insira um email!"
            return false
        }
        if(binding.editPassword.text.isEmpty()) {
            binding.editPassword.error = "A senha é requirida!"
            return false
        }
        return true
    }
}