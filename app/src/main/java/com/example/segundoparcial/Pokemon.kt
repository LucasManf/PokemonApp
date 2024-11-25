package com.example.segundoparcial

data class PokemonResponse(
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)

// Detalles de cada Pokémon
data class PokemonDetails(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<TypeSlot>,
    val sprites: Sprites
)

data class TypeSlot(
    val type: TypeInfo
)

data class TypeInfo(
    val name: String
)

data class Sprites(
    val front_default: String
)