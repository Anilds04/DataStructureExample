package com.example.datastructureexample.programs

fun main(){
    val arr = Array<Int>(5){0}
    val arr1 = IntArray(5){0}
    arr[1] = 4

    println(arr.joinToString() )
}