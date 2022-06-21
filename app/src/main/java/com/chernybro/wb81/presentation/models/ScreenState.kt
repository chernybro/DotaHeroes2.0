package com.chernybro.wb81.presentation.models

sealed class ScreenState<T>(val data: T? = null, val error: Int? = null) {
    class Success<T>(data: T) : ScreenState<T>(data)
    class Error<T>(error: Int, data: T? = null) : ScreenState<T>(data, error)
}
