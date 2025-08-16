package com.example.datastructureexample.programs

fun main(){

    findTheOccurrence("Helloworldo")
}

fun findTheOccurrence(str : String){

    //First method
    /*val result = str.groupingBy {
        it
    }.eachCount()
    */

    //Second method
    val map = hashMapOf<Char, Int>()

    for (st in str){
        map[st] =  map.getOrDefault(st, 0)+1
    }
    println(map)
   // to find maximum repeated
    //println(map.maxByOrNull { it.value })
}