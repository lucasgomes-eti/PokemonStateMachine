package eti.lucasgomes.pokemonstatemachine

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class StateMachineModules {

    @Provides
    fun providePokemonStateMachine(): PokemonStateMachine {
        return PokemonStateMachine()
    }
}