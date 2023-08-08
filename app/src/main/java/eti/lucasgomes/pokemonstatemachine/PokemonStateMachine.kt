package eti.lucasgomes.pokemonstatemachine

import com.freeletics.flowredux.dsl.FlowReduxStateMachine
import dagger.hilt.android.scopes.ViewModelScoped

@ViewModelScoped
class PokemonStateMachine() : FlowReduxStateMachine<PokemonState, PokemonAction>(
    initialState = PokemonState.Hidden
) {
    init {
        spec {
            inState<PokemonState.Hidden> {
                on { _: PokemonAction.Find, state ->
                    state.override { PokemonState.Visible }
                }
            }
            inState<PokemonState.Visible> {
                on { _: PokemonAction.Attack, state ->
                    state.override { PokemonState.Injured }
                }
                on { _: PokemonAction.Catch, state ->
                    state.override { PokemonState.Hidden }
                }
                on { _: PokemonAction.Observe, state ->
                    state.override { PokemonState.Visible }
                }
            }
            inState<PokemonState.Injured> {
                on { _: PokemonAction.Attack, state ->
                    state.override { PokemonState.Dead }
                }
                on { _: PokemonAction.Catch, state ->
                    state.override { PokemonState.Captured }
                }
                on { _: PokemonAction.Observe, state ->
                    state.override { PokemonState.Hidden }
                }
            }
            inState<PokemonState.Captured> {
                //final state
            }
            inState<PokemonState.Dead> {
                //final state
            }
        }
    }
}