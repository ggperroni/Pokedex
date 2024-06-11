package br.com.ggperroni.pokedex.data.remote.responses


import br.com.ggperroni.pokedex.data.remote.responses.Icons
import com.google.gson.annotations.SerializedName

data class GenerationVii(
    val icons: Icons,
    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon
)