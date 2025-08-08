package com.example.datastructureexample

fun main(){

    val singletonClass = SingletonClass.getInstance()
    singletonClass?.display()

    MySingleton.incrementCounter()
    MySingleton.incrementCounter()
}

class SingletonClass{

    companion object{
        private var INSTANCE : SingletonClass? = null

        @Synchronized
        fun getInstance(): SingletonClass?{
            if(INSTANCE == null){
                INSTANCE = SingletonClass()
            }
            return INSTANCE
        }
    }

    fun display(){
        println("Display method")
    }
}


/******************OR*********************/


object MySingleton {
    var counter = 0

    fun incrementCounter() {
        counter++
        println("Counter: $counter")
    }
}