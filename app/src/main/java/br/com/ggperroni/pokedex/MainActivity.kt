package br.com.ggperroni.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.ggperroni.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Navigation()
                }
            }
        }
    }

    @Composable
    fun Navigation() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "pokemon_list_screen"
        ) {
            composable(route = "pokemon_list_screen") {
                TODO()
            }
            composable(
                route = "pokemon_detail_screen/{dominantColor}/{pokemonName}",
                arguments = listOf(
                    navArgument("dominantColor") {
                        type = NavType.IntType
                    },
                    navArgument("pokemonName") {
                        type = NavType.StringType
                    }
                )
            ) {
                val dominantColor = remember {
                    val color = it.arguments?.getInt("dominantColor")
                    color?.let { Color(it) } ?: Color.White
                }
                val pokemonName = remember {
                    it.arguments?.getString("pokemonName")
                }
            }
        }
    }
}
