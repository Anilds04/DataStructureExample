package com.example.datastructureexample.programs

fun main(){

    varArgument(1,4,5,6,7)
}


fun varArgument(vararg numbers : Int) {

    var sum = 0

    for (i in numbers){
        sum +=i
    }

    println(sum)
}