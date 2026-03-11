package com.example.datastructureexample.flow

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

suspend fun main() {

    coroutineScope {

        val producer = ProduceStateExample()
        launch {
            producer.ProduceStateMethod()
        }
        producer.stateFlow.collect {
            println(it)

        }
    }


}

class ProduceStateExample {
    private val _stateflow = MutableStateFlow(0)
    val stateFlow = _stateflow
    suspend fun ProduceStateMethod() {

        for (i in 0..10) {
            delay(1000)
            if (i > 5)
                _stateflow.value = 5
            else
                _stateflow.value = i

        }
    }
}