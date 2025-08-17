package com.example.datastructureexample.ds

fun main(){

    val singletonClass = SingletonClass.getInstance()
    singletonClass?.display()

    MySingleton.incrementCounter()
    MySingleton.incrementCounter()
}

// it means the constructor is private,
// so you cannot create an instance of that class directly
class SingletonClass private constructor(){

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