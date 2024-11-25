package com.example.segundoparcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    //Declaro variables del UI
    private lateinit var buttonRegister : Button
    private lateinit var editTextEnterName: EditText
    private lateinit var editTextEnterPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Inicializo elementos del UI
        buttonRegister = findViewById(R.id.button3)
        editTextEnterName = findViewById(R.id.ETUsername)
        editTextEnterPassword = findViewById(R.id.ETPassword)

        //OnClickListener del boton de registro
        buttonRegister.setOnClickListener {
            if (editTextEnterName.text.isNullOrEmpty() && editTextEnterPassword.text.isNullOrEmpty()) {
                Toast.makeText(this, "Ingrese user y password", Toast.LENGTH_SHORT).show()
            } else {
                val userName = editTextEnterName.text.toString()
                val password = editTextEnterPassword.text.toString()

                val preferences = getSharedPreferences("loginPref", MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putString("name", userName)
                editor.putString("pass", password)
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}