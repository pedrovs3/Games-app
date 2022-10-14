package br.senai.sp.jandira.gamesapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.senai.sp.jandira.gamesapplication.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding

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
            return "Newbie"
        }
        if (value == 2) {
            return "Casual"
        }
        if (value == 3) {
            return "Hardcore Gamer"
        }
        if (value == 4) {
            return ""
        }
        return "Yearner"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_save) {
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater

        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }


}