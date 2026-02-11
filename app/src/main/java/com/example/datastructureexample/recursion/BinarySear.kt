package com.example.datastructureexample.recursion

fun main() {

    val value = binarySearch(arrayOf(1, 2, 4, 5, 6, 8, 9), 80, 0, 6)

    println(value)
}


fun binarySearch(arr: Array<Int>, target: Int, start: Int, end: Int): Int {

    if (start <= end) {
        val mid = (start + end) / 2

        if (arr[mid] == target)
            return mid

        if (arr[mid] < target)
            return binarySearch(arr, target, mid + 1, end)
        else
            return binarySearch(arr, target, start, mid - 1)

    }
    return -1
}