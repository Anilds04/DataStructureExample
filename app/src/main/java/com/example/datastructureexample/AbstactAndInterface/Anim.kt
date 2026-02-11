package com.example.datastructureexample.AbstactAndInterface


interface Anim {
    fun sound()                 // abstract method

    fun eat() {                 // concrete method
        println("Eating...")
    }

    val species: String         // can define a property, but no backing field
}