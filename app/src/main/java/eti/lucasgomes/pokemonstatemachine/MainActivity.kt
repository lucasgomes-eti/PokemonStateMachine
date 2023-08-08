package eti.lucasgomes.pokemonstatemachine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import eti.lucasgomes.pokemonstatemachine.ui.theme.PokemonStateMachineTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonStateMachineTheme {
                PokemonCatcher()
            }
        }
    }
}

@Composable
fun PokemonCatcher() {
    val viewModel = hiltViewModel<PokemonCatcherViewModel>()
    val uiState by viewModel.rememberState()

    Column {
        when (uiState) {
            is PokemonState.Hidden -> {
                Text(text = "Pokemon is Hidden")
                Button(onClick = { viewModel.dispatch(PokemonAction.Find) }) {
                    Text(text = "Search for it")
                }
            }
            is PokemonState.Visible -> {
                Text(text = "Pokemon is Visible")
                Button(onClick = { viewModel.dispatch(PokemonAction.Attack) }) {
                    Text(text = "Attack")
                }
                Button(onClick = { viewModel.dispatch(PokemonAction.Catch) }) {
                    Text(text = "Catch")
                }
                Button(onClick = { viewModel.dispatch(PokemonAction.Observe) }) {
                    Text(text = "Observe")
                }
            }
            is PokemonState.Injured -> {
                Text(text = "Pokemon is Injured")
                Button(onClick = { viewModel.dispatch(PokemonAction.Attack) }) {
                    Text(text = "Attack")
                }
                Button(onClick = { viewModel.dispatch(PokemonAction.Catch) }) {
                    Text(text = "Catch")
                }
                Button(onClick = { viewModel.dispatch(PokemonAction.Observe) }) {
                    Text(text = "Observe")
                }
            }
            is PokemonState.Captured -> {
                Text(text = "Pokemon is Captured")
            }
            is PokemonState.Dead -> {
                Text(text = "Pokemon is Dead")
            }
            null -> Unit
        }
    }
}