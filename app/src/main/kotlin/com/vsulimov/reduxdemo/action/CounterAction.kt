package com.vsulimov.reduxdemo.action

import com.vsulimov.redux.Action

/**
 * Actions to change the counter value.
 */
sealed class CounterAction : Action {

    /**
     * Dispatch this to increment counter by one.
     */
    object Increment : CounterAction()

    /**
     * Dispatch this to reset counter to 0.
     */
    object Reset : CounterAction()
}
