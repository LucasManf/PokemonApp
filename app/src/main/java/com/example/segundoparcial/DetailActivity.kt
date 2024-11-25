package com.example.segundoparcial

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    //Declaro variables del UI
    private lateinit var imageView: ImageView
    private lateinit var tvName: TextView
    private lateinit var tvNro: TextView
    private lateinit var tvType1: TextView
    private lateinit var tvType2: TextView
    private lateinit var tvHeight: TextView
    private lateinit var tvWeight: TextView
    private lateinit var buttonVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //Inicializo elementos del UI
        imageView = findViewById(R.id.imageDetail)
        tvName = findViewById(R.id.TVDetailName)
        tvNro = findViewById(R.id.TVDetailNumber)
        tvType1 = findViewById(R.id.TVDetailType1)
        tvType2 = findViewById(R.id.TVDetailType2)
        tvHeight = findViewById(R.id.TVDetailHeight)
        tvWeight = findViewById(R.id.TVDetailWeigth)
        buttonVolver = findViewById(R.id.button)

        //Recupero extras del intent
        val bundle = intent.extras
        val image = bundle?.getString("pokemonImage", "")
        val nro = bundle?.getInt("pokemonId", 0)
        val name = bundle?.getString("pokemonName", "")
        val height = bundle?.getInt("pokemonHeight", 0)
        val weight = bundle?.getInt("pokemonWeight", 0)
        val type1 = bundle?.getString("pokemonPrimaryType", "")
        val type2 = bundle?.getString("pokemonSecondaryType", null)


        //Muestro los datos elegidos en el UI
        Picasso.get()
            .load(image)
            .into(imageView)

        tvName.text = "$name"
        tvNro.text = "Pokedex No: $nro"
        tvType1.text = "Primary Type: $type1"
        tvType2.text = "Secondary Type: $type2"
        tvHeight.text = "Height: $height"
        tvWeight.text = "Weight: $weight"

        //OnClickListener del boton para volver a la actividad anterior
        buttonVolver.setOnClickListener {
            finish()
        }

    }
}