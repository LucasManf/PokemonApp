package com.example.segundoparcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SecondActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private lateinit var buttonVolver: Button
    private var pokemonDetailsList = mutableListOf<PokemonDetails>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        recyclerView = findViewById(R.id.recyclerView)
        buttonVolver = findViewById(R.id.button2)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(pokemonDetailsList)
        recyclerView.adapter = adapter

        adapter.onItemClickListener = { selectedPokemon ->
            val intent = Intent(this, DetailActivity::class.java).apply {

                val secondType = selectedPokemon.types.getOrNull(1)?.type?.name

                putExtra("pokemonId", selectedPokemon.id)
                putExtra("pokemonName", selectedPokemon.name)
                putExtra("pokemonImage", selectedPokemon.sprites.front_default)
                putExtra("pokemonWeight", selectedPokemon.weight)
                putExtra("pokemonHeight", selectedPokemon.height)
                putExtra("pokemonPrimaryType", selectedPokemon.types[0].type.name)
                putExtra("pokemonSecondaryType", secondType)
            }
            startActivity(intent)
        }

        getPokemonList()

        buttonVolver.setOnClickListener {
            finish()
        }
    }

    private fun getPokemonList() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiService::class.java).getPokemonList()
            val response = call.body()

            if (call.isSuccessful) {
                val results = response?.results

                results?.forEach { pokemonResult ->
                    fetchPokemonDetails(pokemonResult)
                }
            }
        }
    }

    private fun fetchPokemonDetails(pokemonResult: PokemonResult) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(ApiService::class.java).getPokemonDetails(pokemonResult.url)
            val response = call.body()

            runOnUiThread {
                if (call.isSuccessful && response != null) {
                    pokemonDetailsList.add(response) // Agrega los detalles completos a la lista

                    adapter.notifyDataSetChanged()

                }
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }
}