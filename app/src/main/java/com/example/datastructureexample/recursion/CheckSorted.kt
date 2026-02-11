package com.example.datastructureexample.recursion

fun main() {

    var result = checkIsArraySorted(6, arrayOf(1, 2, 3, 4, 5, 6))
    println(result)
}

fun checkIsArraySorted(n: Int, arr: Array<Int>): Boolean {


    if (n == 0 || n == 1)
        return true

    return arr[n - 1] >= arr[n - 2] && checkIsArraySorted(n - 1, arr)
}