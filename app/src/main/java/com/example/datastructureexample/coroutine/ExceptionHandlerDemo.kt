package com.example.datastructureexample.coroutine

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope


suspend fun main(){
    val handler = CoroutineExceptionHandler{
        _, exception ->
    }

    coroutineScope {
        launch (handler){
            throw Exception("Error")
        }
    }

}


suspend fun test(){

    supervisorScope {
        delay(1000)
    }

}

