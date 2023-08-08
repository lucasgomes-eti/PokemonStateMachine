package eti.lucasgomes.pokemonstatemachine

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.freeletics.flowredux.compose.rememberState
import com.freeletics.flowredux.dsl.FlowReduxStateMachine
import kotlinx.coroutines.launch

abstract class BaseViewModel<State: Any, Action: Any>(
    private val stateMachine: FlowReduxStateMachine<State, Action>
): ViewModel() {

    @Composable
    fun rememberState() = stateMachine.rememberState()

    fun dispatch(action: Action) = viewModelScope.launch {
        stateMachine.dispatch(action)
    }
}