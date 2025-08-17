package com.example.datastructureexample.programs
fun main(){
    val interfaceDemo = InterfaceDemo("test")
    interfaceDemo.photo()
    interfaceDemo.video()

    A.test()
    testObj.video()

  //  Myclass1().demo()
}


class InterfaceDemo(override val name: String) : Camera, Camera2{

    val newValue = name

    override fun photo() {
        println("I am photo")
        println(name)
    }

    override fun video() {

    }


}

interface Camera{

    val name : String
    fun photo()
    fun video(){
        println("I am video")
    }

}

interface Camera2{

    val name : String
    fun photo()
    fun video(){
        println("I am video")
    }

}

abstract class Abs(){

    fun ab(){

    }

    abstract fun cd()
}

//Singleton in kotlin
object A {

    fun test(){

    }
}


//Anonymouse object (no name) Quick encapsulation can implement
// interface and for event handling
val testObj = object : Camera{
    override val name: String
        get() = TODO("Not yet implemented")

    override fun photo() {
        TODO("Not yet implemented")
    }

}


//object can't be created
class Myclass1 private constructor(){
    fun demo(){

    }
}