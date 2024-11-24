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
        private val image: ImageView = view.findViewById(R.id.imageView)
        private val nameTV: TextView = view.findViewById(R.id.textView)
        private val idTV: TextView = view.findViewById(R.id.idTextView)

        fun bind(pokemon: PokemonDetails) {
            nameTV.text = pokemon.name
            idTV.text = pokemon.id.toString()

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