package com.sun.americanroom.data.source.local

import java.lang.Exception

interface OnFetchDataLocalListener<T> {

    fun onSuccess(data: T)

    fun onFail(exception: Exception?)
}
