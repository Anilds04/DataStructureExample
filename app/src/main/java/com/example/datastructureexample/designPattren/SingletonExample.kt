package com.example.datastructureexample.designPattren

class SingletonExample private constructor(){

    companion object {

        var INSTANCE : SingletonExample? = null

        @Synchronized
        fun getInstance() : SingletonExample?{
            if(INSTANCE == null)
                INSTANCE = SingletonExample()

            return INSTANCE
        }
    }
}


object MySingleton {
    var counter = 0

    fun doSomething() {
        counter++
        println("Doing something! Counter = $counter")
    }
}