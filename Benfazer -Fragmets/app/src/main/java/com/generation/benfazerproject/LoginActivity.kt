package com.generation.benfazerproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.generation.benfazerproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Main)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentMain = Intent(this, MainActivity::class.java)

        binding.LoginButton.setOnClickListener {
            if(binding.emailText.text.isEmpty() || binding.senhaText.text.isEmpty()){
                Toast.makeText(
                    this, "Preencha todos os campos",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                startActivity(intentMain)
            }
        }
    }
}