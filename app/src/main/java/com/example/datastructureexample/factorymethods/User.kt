package com.example.datastructureexample.factorymethods

class User private constructor(val name : String, val age : Int){

    companion object {
        fun create(name: String, age: Int): User {
            println("Creating user")
            return User(name,age)
        }
    }
}

//Another method

data class Shape(val  type : String,val sides :Int){

    companion object{
        fun square () : Shape =  Shape("Square", 4)
        fun triangle() : Shape = Shape("Triangle", 3)
    }
}