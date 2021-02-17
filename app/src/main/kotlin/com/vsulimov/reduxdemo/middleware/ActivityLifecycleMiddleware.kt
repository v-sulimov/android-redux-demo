package com.vsulimov.reduxdemo.middleware

import com.vsulimov.android.lifecycle.ActivityLifecycleAction
import com.vsulimov.redux.Action
import com.vsulimov.redux.Middleware
import com.vsulimov.redux.Next
import com.vsulimov.reduxdemo.action.CounterAction
import com.vsulimov.reduxdemo.state.ApplicationState

/**
 * This middleware keeps track of [ActivityLifecycleAction] and resets the counter
 * by returning the [CounterAction.Reset] when [ActivityLifecycleAction.OnDestroy] event arrives.
 */
object ActivityLifecycleMiddleware : Middleware<ApplicationState> {

    override fun handleAction(
        action: Action,
        state: ApplicationState,
        next: Next<ApplicationState>
    ): Action {
        val newAction = when (action) {
            is ActivityLifecycleAction.OnDestroy ->
                handleActivityOnDestroy(action)

            else ->
                action
        }
        return next(newAction, state)
    }

    private fun handleActivityOnDestroy(action: ActivityLifecycleAction.OnDestroy): Action =
        if (action.isFinishing) CounterAction.Reset else action
}
