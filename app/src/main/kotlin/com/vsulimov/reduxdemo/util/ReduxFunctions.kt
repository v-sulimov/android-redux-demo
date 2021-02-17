package com.vsulimov.reduxdemo.util

import com.vsulimov.redux.Action
import com.vsulimov.redux.Subscription
import com.vsulimov.reduxdemo.Application
import com.vsulimov.reduxdemo.state.ApplicationState

/**
 * This file contains handy functions for all redux related functionality.
 */

fun dispatch(action: Action) =
    Application.getInstance().store.dispatch(action)

fun subscribe(subscription: Subscription<ApplicationState>) =
    Application.getInstance().store.subscribe(subscription)

fun unsubscribe(subscription: Subscription<ApplicationState>) =
    Application.getInstance().store.unsubscribe(subscription)
