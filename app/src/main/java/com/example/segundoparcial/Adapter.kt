package com.example.segundoparcial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adapter(private val pokemons: List<PokemonDetails>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    lateinit var onItemClickListener: (PokemonDetails) -> Unit

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        //Declaro variables del UI
        private val image: ImageView = view.findViewById(R.id.imageView)
        private val nameTV: TextView = view.findViewById(R.id.textView)
        private val typeTV: TextView = view.findViewById(R.id.TypeTextView)

        fun bind(pokemon: PokemonDetails) {
            val pokemonType = pokemon.types[0].type.name
            nameTV.text = pokemon.name
            typeTV.text = "type: $pokemonType"

            Picasso.get()
                .load(pokemon.sprites.front_default)
                .into(image)

            view.setOnClickListener {
                onItemClickListener(pokemon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }
}