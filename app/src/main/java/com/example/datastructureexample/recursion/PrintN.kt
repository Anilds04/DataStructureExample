package com.example.datastructureexample.recursion

fun main(){

    printN(10)
}


fun printN( num : Int){

    if(num == 1 ){
        println(num)
        return
    }
    println(num)
    printN(num-1)
}