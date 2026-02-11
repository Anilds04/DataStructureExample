package com.example.datastructureexample.programs

fun main(){
    val arr = Array<Int>(5){0}
    val arr1 = IntArray(5){0}
    arr[1] = 4

    val arr3 = arrayOf(3,6)

    println(arr.joinToString() )


    for((i,e) in arr3.withIndex()){
        println("$i -> $e")
    }

    arr3.forEach {
        println(it)
    }

    val ar4 = arr3.map {
        it*3
    }
    println(ar4)

    val ar5 = arr3.filter {
        it>5
    }
    println(ar5)


}