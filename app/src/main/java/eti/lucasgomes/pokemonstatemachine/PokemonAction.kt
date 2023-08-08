package eti.lucasgomes.pokemonstatemachine

sealed interface PokemonAction {
    object Find : PokemonAction
    object Attack : PokemonAction
    object Observe : PokemonAction
    object Catch : PokemonAction
}