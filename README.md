# android-redux-demo

A simple application that demonstrates the use of the redux library in Android.


## What is it?
This is a reference implementation of a single screen activity android application
with redux architecture. Middlewares and reducers are covered with tests.
The view contains no business logic and only cares about drawing himself with the provided data and dispatching actions when some event occurs. And yes, this app survives activity re-creation and DKA out of the box.

## This is how it looks like
<p float="left">
   <img src="assets/counter-app-initial.png" width="30%">
   <img src="assets/counter-app-incremented.png" width="30%">
</p>

## How can I get it in my application?
Redux library lives [here](https://gitlab.com/v.sulimov/android-redux-kotlin).
