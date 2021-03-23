package com.vsulimov.reduxdemo.util

import com.vsulimov.redux.Action
import com.vsulimov.redux.Subscription
import com.vsulimov.reduxdemo.AppComponent
import com.vsulimov.reduxdemo.state.ApplicationState

/**
 * This file contains handy functions for all redux related functionality.
 */

fun dispatch(action: Action) =
    AppComponent.store.dispatch(action)

fun subscribe(subscription: Subscription<ApplicationState>) =
    AppComponent.store.subscribe(subscription)

fun unsubscribe(subscription: Subscription<ApplicationState>) =
    AppComponent.store.unsubscribe(subscription)
