package com.vsulimov.reduxdemo.reducer

import android.os.Build
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
internal class CounterReducerTest {

    lateinit var store: ApplicationStore

    @Before
    fun setUp() {
        store = ApplicationStore(
            initialState = ApplicationState(),
            middlewares = emptyList(),
            reducers = listOf(CounterReducer)
        )
    }

    @Test
    fun `increment counter action should increment value by one`() {
        store.dispatch(CounterAction.Increment)
        assert(store.getState().counter == 1)
    }

    @Test
    fun `reset counter should set counter value to 0`() {
        store.dispatch(CounterAction.Reset)
        assert(store.getState().counter == 0)
    }
}
