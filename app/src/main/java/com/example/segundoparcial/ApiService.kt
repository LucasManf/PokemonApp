package com.example.segundoparcial;

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    // Primer endpoint: obtiene la lista de Pokémon con sus nombres y URLs
    @GET("pokemon")
    suspend fun getPokemonList(): Response<PokemonResponse>

    // Segundo endpoint: obtiene los detalles de un Pokémon específico usando su URL
    @GET
    suspend fun getPokemonDetails(@Url url: String): Response<PokemonDetails>
}