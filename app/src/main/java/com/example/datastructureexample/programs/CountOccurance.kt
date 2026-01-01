package com.example.datastructureexample.programs

fun main(){

    val result = countChars("aabbcdabcdf".toCharArray())
}

fun countChars(chars: CharArray) {

    val map = HashMap<Char, Int>()
    for (c in chars ){
        map [c] = map.getOrDefault(c, 0)+1
    }

    val sb = StringBuilder()

    for ((key, value ) in map){

        sb.append(key)
        sb.append(value)
    }

    println(sb.toString())

}
