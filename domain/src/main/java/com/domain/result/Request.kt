package com.domain.result

inline class Request<T>(private val result: Result<T>) {

    companion object {
        inline fun <T> success(value: T): Request<T> =
            Request(Result.success(value))
        inline fun <T> error(exception: Exception): Request<T> =
            Request(Result.failure(exception))
    }

    fun getResponse(): T? = when {
        result.isFailure -> throw (result.exceptionOrNull() as Exception)
        else -> result.getOrNull()
    }
}

suspend infix fun <T> Request<T>.or(defaultValue: () -> T): T = try {
    this.getResponse() ?: defaultValue()
} catch (e: Exception) { defaultValue() }
