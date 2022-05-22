package ru.lemaitre.bankcomposesample.common.domain

sealed class StateData<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T): StateData<T>(data)
    class Error<T>(message: String?, data: T? = null): StateData<T>(data, message)
    class Loading<T>(data: T? = null): StateData<T>(data)
}