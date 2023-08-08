package eti.lucasgomes.pokemonstatemachine

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonCatcherViewModel @Inject constructor(
    pokemonStateMachine: PokemonStateMachine
): BaseViewModel<PokemonState, PokemonAction>(pokemonStateMachine){}