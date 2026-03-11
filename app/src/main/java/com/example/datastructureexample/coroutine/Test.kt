package com.example.datastructureexample.coroutine

import kotlinx.coroutines.*

suspend fun main() {

    println("Start Parallel Execution")
    val str = "hghghjhjhhjhjhj"
    println(str.reversed())
    println(str)

    val a :Int
    val  b :Int



    coroutineScope {

       val job1 = launch {
            delay(1000)
            println("Task 1 Done")
        }

          job1.join()

        val job2 = launch {
            delay(1000)
            println("Task 2 Done")
        }

        job2.join()
    }


    println("Parallel Execution Finished")
}

data class Nam(val list : MutableList<Int>){
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }



}

