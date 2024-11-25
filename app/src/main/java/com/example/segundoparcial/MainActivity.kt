package com.example.segundoparcial

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    //Declaro variables del UI
    private lateinit var usernameET: EditText
    private lateinit var passwordET: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializo elementos del UI
        usernameET = findViewById(R.id.UsernameET)
        passwordET = findViewById(R.id.PasswordET)
        loginButton = findViewById(R.id.LoginButton)
        registerButton = findViewById(R.id.RegisterButton)

        //Recupero elementos guardados con SharedPreferences
        val preferences = getSharedPreferences("loginPref", MODE_PRIVATE)
        val usernamePref = preferences.getString("name", "")
        val passwordPref = preferences.getString("pass", "")


        //OnClickListener de los botones Login y Register
        loginButton.setOnClickListener {
            login(usernamePref, passwordPref)
        }

        registerButton.setOnClickListener {
            register()
        }
    }

    //Funcion Register
    private fun register() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    //Funcion Login
    private fun login(usernamePref: String?, passwordPref: String?) {
        val username = usernameET.text.toString()
        val password = passwordET.text.toString()

        if (username == usernamePref && password == passwordPref) {

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }
}