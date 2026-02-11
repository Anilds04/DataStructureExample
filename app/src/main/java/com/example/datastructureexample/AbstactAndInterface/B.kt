package com.example.datastructureexample.AbstactAndInterface


//Object as a Declaration
//Singleton
object B {

    val name: Int = 0
    fun test() {

    }
}

//Object as Expression
val data = object  {
    val name : Int = 0
    fun test (){

    }
}

val obj = object : ab{
    override fun clonable() {

    }

}

interface ab {

    fun clonable()
}

fun main (){

    B.test()
}