package com.example.datastructureexample.coroutine

import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{

    val vm = UiViewModel()

    val counterJob = launch {
        vm.counter.collect{
            println("Counter value $it")
        }
    }



    val eventsJob = launch {
        vm.events.collect(){
            println("Events collected $it")
        }
    }


    repeat(5){
        vm.increment()
        delay(1000)
    }

    counterJob.cancel()
    eventsJob.cancel()
}


class UiViewModel(){

    private val _counter  = MutableStateFlow<Int>(0)
    val counter : StateFlow<Int> = _counter

    private val _events = MutableSharedFlow<String>(0)
    val events = _events


    suspend fun increment(){

        _counter.value +=1

        if(_counter.value % 3 == 0){
            _events.emit("Counter reached ${_counter.value}")
        }
    }

}