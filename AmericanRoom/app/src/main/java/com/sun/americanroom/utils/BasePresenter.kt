package com.sun.americanroom.utils

interface BasePresenter<T> {

    fun onStart()

    fun onStop()

    fun setView(view: T?)
}
