package com.example.datastructureexample.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking


fun main() = runBlocking{

    simulateUserTyping()
        .debounce(300)
        .filter { it.isNotBlank() }
        .collect{ value ->
            println("Search triggered for $value")
        }
}

fun simulateUserTyping(): Flow<String> {
    return flow {
        emit("hi")
        delay(100)
        emit("he")
        delay(100)
        emit("hel")
        delay(400)
        emit("hell")
        delay(100)
        emit("hello")
    }
}