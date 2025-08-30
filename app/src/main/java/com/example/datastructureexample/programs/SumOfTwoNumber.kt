package com.example.datastructureexample.programs


fun main(){
    val arr = arrayOf(1,3,5,6,8,9,12,14)

   // println( findIsExistWithNodes(arr,26))
    println( findIsExist(arr,27))
}

fun findIsExist(array: Array<Int>, target :Int) : Boolean{

    var result = false


//    for(i = 0 ; i< array.size; i++)
    for (i in 0 until  array.size){
        println("$i ")
    //    for(j = i+1 ; j< array.size; j++)
        for (j in i+1 until array.size){
            println("$i  -  $j")
            if(target == (array[i] + array[j])) {
             //   println("$i  -  $j")

                return true
            }
        }
    }
    return result
}

fun findIsExistWithNodes(array: Array<Int>, target :Int) : Boolean{

    val result = false

    var start = 0
    var end = array.size -1

    while (start<end){

        if( array[start] + array[end] == target)
            return true

        if(target < array[start] + array[end])
            end -= 1
        else
            start += 1
    }

    return result
}