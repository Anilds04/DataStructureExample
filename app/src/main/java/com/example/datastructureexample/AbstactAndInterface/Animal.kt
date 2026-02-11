package com.example.datastructureexample.AbstactAndInterface

abstract class Animal {
    abstract fun sound()   // abstract method

    fun eat() {            // concrete method
        println("Eating...")
    }

    var age: Int = 0       // can have properties
}
