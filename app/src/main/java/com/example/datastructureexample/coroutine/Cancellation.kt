package com.example.datastructureexample.coroutine

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{

    val scope = launch {
        longRunningTask()
    }
    delay(1000)
    println("Cancelling")
    scope.cancelAndJoin()
    println("Done")
}

suspend fun longRunningTask() = coroutineScope {

    launch {
        for (i in  1..10) {
            if (!isActive) {
                println("Cancelled")
                return@launch
            }

            println("Processing chunk $i")
            delay(300)
        }
    }

}


fun t(){
    val scope = CoroutineScope(IO).launch {

    }

    CoroutineScope(IO).launch {

    }

    scope.cancel()
}