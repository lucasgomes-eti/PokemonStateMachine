package eti.lucasgomes.pokemonstatemachine

sealed interface PokemonState {
    object Hidden : PokemonState
    object Visible : PokemonState
    object Injured : PokemonState
    object Captured : PokemonState
    object Dead : PokemonState
}