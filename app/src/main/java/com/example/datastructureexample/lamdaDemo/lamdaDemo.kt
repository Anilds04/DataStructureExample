package com.example.datastructureexample.lamdaDemo

fun main() {

    val lamda1 = { a: Int -> a * a }

    val lamda2: (Int) -> Int = { n -> n * n }

    val lamda4: (Int) -> Int = { it*it }

    val lamda3 = {
        10
        println("lamda 3")
        "return"
    }


    println(lamda1(2))
    println(lamda2(4))
    println(lamda3())
}



fun test(){

   add(5,6) {
       m, n -> m+n
   }
}


fun add( a : Int, b : Int, sum : (Int, Int) -> Unit){

    sum(a, b)
}