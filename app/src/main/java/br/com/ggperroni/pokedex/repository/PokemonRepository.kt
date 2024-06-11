package br.com.ggperroni.pokedex.repository

import br.com.ggperroni.pokedex.data.remote.PokeApi
import br.com.ggperroni.pokedex.data.remote.responses.Pokemon
import br.com.ggperroni.pokedex.data.remote.responses.PokemonList
import br.com.ggperroni.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error(message = "An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error(message = "An unknown error occurred.")
        }
        return Resource.Success(response)
    }
}