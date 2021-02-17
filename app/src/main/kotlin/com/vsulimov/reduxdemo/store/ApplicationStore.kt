package com.vsulimov.reduxdemo.store

import com.vsulimov.redux.AbstractStore
import com.vsulimov.redux.Middleware
import com.vsulimov.redux.Reducer
import com.vsulimov.reduxdemo.state.ApplicationState

/**
 * Concrete variant of the redux store.
 */
class ApplicationStore(
    initialState: ApplicationState,
    middlewares: List<Middleware<ApplicationState>>,
    reducers: List<Reducer<ApplicationState>>
) : AbstractStore<ApplicationState>(initialState, middlewares, reducers)
