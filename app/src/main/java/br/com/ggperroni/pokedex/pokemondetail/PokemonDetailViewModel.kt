package br.com.ggperroni.pokedex.pokemondetail

import androidx.lifecycle.ViewModel
import br.com.ggperroni.pokedex.data.remote.responses.Pokemon
import br.com.ggperroni.pokedex.repository.PokemonRepository
import br.com.ggperroni.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }

}