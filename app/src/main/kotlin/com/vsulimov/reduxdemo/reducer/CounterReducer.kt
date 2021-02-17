package com.vsulimov.reduxdemo.reducer

import com.vsulimov.redux.Action
import com.vsulimov.redux.Reducer
import com.vsulimov.reduxdemo.action.CounterAction
import com.vsulimov.reduxdemo.state.ApplicationState

/**
 * Reducer which keeps track of [CounterAction] and changes the state based on the event.
 */
object CounterReducer : Reducer<ApplicationState> {

    override fun reduce(action: Action, state: ApplicationState): ApplicationState =
        when (action) {
            is CounterAction.Increment ->
                state.copy(counter = state.counter.inc())

            is CounterAction.Reset ->
                state.copy(counter = 0)

            else ->
                state
        }
}
