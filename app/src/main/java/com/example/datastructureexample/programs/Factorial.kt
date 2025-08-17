package com.example.datastructureexample.programs

import kotlin.time.times

fun main(){

    factIterative(5)

    println(factRecursive(5))
}



fun factIterative(num : Int){

    var result = 1

    for (i in num downTo 1){
       result = result*i
    }
    println(result)
}


fun factRecursive(num : Int) : Int{

    var fact = num

    if(num <= 1)
        return 1
    else
        fact *= factRecursive(num-1)


    return fact
}