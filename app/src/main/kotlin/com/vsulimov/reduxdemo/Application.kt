package com.vsulimov.reduxdemo

import android.app.Application
import com.vsulimov.reduxdemo.middleware.ActivityLifecycleMiddleware
import com.vsulimov.reduxdemo.reducer.CounterReducer
import com.vsulimov.reduxdemo.state.ApplicationState
import com.vsulimov.reduxdemo.store.ApplicationStore

/**
 * Custom application class which holds the store with the entire application state.
 * The lifecycle of the store and application state are corresponds to the application lifecycle.
 */
class Application : Application() {

    lateinit var store: ApplicationStore

    override fun onCreate() {
        super.onCreate()
        instance = this
        createStore()
    }

    private fun createStore() {
        store = ApplicationStore(
            initialState = ApplicationState(),
            middlewares = listOf(ActivityLifecycleMiddleware),
            reducers = listOf(CounterReducer)
        )
    }

    companion object {

        private lateinit var instance: com.vsulimov.reduxdemo.Application

        fun getInstance() = instance
    }
}
