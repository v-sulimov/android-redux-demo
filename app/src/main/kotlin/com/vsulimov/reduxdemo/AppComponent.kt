package com.vsulimov.reduxdemo

import com.vsulimov.reduxdemo.middleware.ActivityLifecycleMiddleware
import com.vsulimov.reduxdemo.reducer.CounterReducer
import com.vsulimov.reduxdemo.state.ApplicationState
import com.vsulimov.reduxdemo.store.ApplicationStore

object AppComponent {

    val store = ApplicationStore(
        initialState = ApplicationState(),
        middlewares = listOf(ActivityLifecycleMiddleware),
        reducers = listOf(CounterReducer)
    )
}
