package com.example.datastructureexample.programs

fun main() {

    // println(fibIterative(10))
    //  println(fibList(10))
    println(fibRecursiveNum(3))
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


fun fibIterativeNum(n: Int): Int {

    if (n == 0) return 0
    if (n == 1) return 1

    var prev1 = 1
    var prev2 = 0

    var current = 0

    for (i in 2..n) {

        current = prev1 + prev2
        prev2 = prev1
        prev1 = current
    }

    return current
}


fun fibRecursiveNum(n: Int): Int {

    if (n == 0 || n == 1) return n

    return fibRecursiveNum(n - 1) + fibRecursiveNum(n - 2)
}