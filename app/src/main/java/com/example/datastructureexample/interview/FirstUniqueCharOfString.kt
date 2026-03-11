package com.example.datastructureexample.interview

fun main(){

    val str  = "Welcome India"

    println(findString(str))
}


fun findString(str : String ): Char?{

    if(str.isEmpty())
        return null

    val map = mutableMapOf<Char, Int>()

    for(char in str){
        val lowerChar = char.lowercaseChar()
        map[lowerChar] = map.getOrDefault(lowerChar, 0)+1
    }

    println(map)

    for(char in str){
      //  println("${m.key} -> ${m.value}")
        val lowerChar = char.lowercaseChar()
        if(map[lowerChar] == 1)
            return char
    }

    return null
}