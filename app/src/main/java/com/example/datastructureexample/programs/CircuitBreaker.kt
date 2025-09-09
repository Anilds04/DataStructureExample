package com.example.datastructureexample.programs


fun main() {

    val breaker = CircuitBreaker(3, 3000)

    repeat(5) {

        breaker.call {
            if (it < 3) throw RuntimeException("Service failed")
            "Service OK"
        }.also { println("Call result $it\n") }
    }

    Thread.sleep(4000)
    println("Retry after timeout..")

    breaker.call { "Service recovered" }
}


enum class State {
    OPEN,
    CLOSED,
    HALF_OPEN
}

class CircuitBreaker(val failureThreshold: Int, val resetTimeout: Int) {

    private var state = State.CLOSED
    private var failureCount = 0
    private var lastFailureTime = 0L
    fun <T> call(onAction: () -> T): T? {

        when (state) {
            State.OPEN -> {
                if (System.currentTimeMillis() - lastFailureTime > resetTimeout) {
                    println("Moving to half open state")
                    state = State.HALF_OPEN
                } else {
                    println("Circuit is open - call blocked")
                    return null
                }
            }

            State.HALF_OPEN -> {
                // Allow limited trial
            }
            State.CLOSED -> {
                // Normal operation
            }
        }

        return try {
            val result = onAction()
            onSuccess()
            result
        }catch (ex : Exception){
            onFailure(ex)
            null
        }
    }

    private fun onSuccess(){
        if(state ==  State.HALF_OPEN){
            println("Success in HALF_OPEN")
            reset()
        }else if(state == State.CLOSED){
            failureCount = 0
        }
    }

    private fun onFailure(ex : Exception){
        println("Failure ${ex.message}")
        failureCount++
        lastFailureTime = System.currentTimeMillis()

        if(failureCount >= failureThreshold){
            println("Threshold reached to open circuit")
            state = State.OPEN
        }
    }

    private fun reset(){
        state = State.CLOSED
        failureCount = 0
    }

}