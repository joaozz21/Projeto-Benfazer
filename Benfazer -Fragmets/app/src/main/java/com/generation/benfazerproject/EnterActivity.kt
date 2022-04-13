package com.generation.benfazerproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.generation.benfazerproject.databinding.ActivityEnterBinding
import com.generation.benfazerproject.databinding.ActivityLoginBinding

class EnterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Main)

        binding = ActivityEnterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentLogin = Intent(this, LoginActivity::class.java)

        binding.buttonONG.setOnClickListener {
            startActivity(intentLogin)
        }

        binding.buttonDoador.setOnClickListener {
            Toast.makeText(
                this, "Não disponível no momento",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}