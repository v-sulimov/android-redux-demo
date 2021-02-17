package com.vsulimov.reduxdemo.middleware

import android.os.Build
import com.vsulimov.android.lifecycle.ActivityLifecycleAction
import com.vsulimov.redux.Action
import com.vsulimov.redux.Reducer
import com.vsulimov.reduxdemo.action.CounterAction
import com.vsulimov.reduxdemo.state.ApplicationState
import com.vsulimov.reduxdemo.store.ApplicationStore
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.P])
internal class ActivityLifecycleMiddlewareTest {

    private var reducerLastReceivedAction: Action? = null

    lateinit var store: ApplicationStore

    @Before
    fun setUp() {
        reducerLastReceivedAction = null
        store = ApplicationStore(
            initialState = ApplicationState(),
            middlewares = listOf(ActivityLifecycleMiddleware),
            reducers = listOf(TestReducer())
        )
    }

    @Test
    fun `on destroy action with isFinishing = true should reset the counter`() {
        store.dispatch(ActivityLifecycleAction.OnDestroy(isFinishing = true))
        assert(reducerLastReceivedAction == CounterAction.Reset)
    }

    @Test
    fun `on destroy action with isFinishing = false should not reset the counter`() {
        store.dispatch(ActivityLifecycleAction.OnDestroy(isFinishing = false))
        assert(reducerLastReceivedAction == ActivityLifecycleAction.OnDestroy(isFinishing = false))
    }

    inner class TestReducer : Reducer<ApplicationState> {

        override fun reduce(action: Action, state: ApplicationState): ApplicationState {
            reducerLastReceivedAction = action
            return state
        }
    }
}
