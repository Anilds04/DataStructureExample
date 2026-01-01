package com.example.datastructureexample.programs

fun main(){

    val result = removeDuplicates("aabbcdabcdf".toCharArray())
}

fun removeDuplicates(chars: CharArray) {

    val set = HashSet<Char>()

    for(c in chars){
        set.add(c)
    }

    val sb = StringBuilder()
    var sb1 : String = ""
    for(s in set){

        sb.append(s)
        sb1 = sb1 + s
    }

    println(sb.toString())
    println(sb1)
}