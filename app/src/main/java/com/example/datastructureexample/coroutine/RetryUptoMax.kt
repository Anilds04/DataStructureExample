package com.example.datastructureexample.coroutine

import com.example.datastructureexample.programs.Response
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() = runBlocking{

    val result = fetchDataWithRetry(5)
    println("Final result : $result")
}

//Api call that fails randomly
suspend fun fetchData() : String{

    delay(100)
    if (Random.nextBoolean()){
        throw RuntimeException("Network Failure")
    }

    return "Success"
}

//Retry login fun


suspend fun fetchDataWithRetry(maxRetry : Int) : String{

    repeat(maxRetry -1){ attempt ->

        try {
            return fetchData()
        }
        catch (ex : Exception){
            println("Attempt ${attempt+1} failed retrying........")
            delay(100)
        }
    }

    return fetchData()
}