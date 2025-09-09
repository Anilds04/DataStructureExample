package com.example.datastructureexample.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{

    flowData().collect{
        println(it)
    }
}

fun flowData(): Flow<Int> {
    return flow {
        for (i in 1..10) {
            delay(300)
            emit(i)
        }
    }
}