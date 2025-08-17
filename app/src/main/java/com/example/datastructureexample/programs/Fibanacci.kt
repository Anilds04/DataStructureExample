package com.example.datastructureexample.programs

fun main() {

   // println(fibIterative(10))
    println(fibList(10))
}


fun fibIterative(number: Int): MutableList<Int> {
    if (number == 0)
        return mutableListOf(0)
    if (number == 1)
        return mutableListOf(0, 1)
    var result = mutableListOf<Int>(0, 1)

    for (n in 2..number) {
        result.add(result[n - 1] + result[n - 2])
    }
    return result
}


fun fibList(n: Int): List<Int> {
    return when (n) {
        0 -> listOf(0)
        1 -> listOf(0, 1)
        else -> {
            val prev = fibList(n - 1)        // recursive call
            val next = prev[prev.lastIndex] + prev[prev.lastIndex - 1]
            prev + next                      // append next value to list
        }
    }
}