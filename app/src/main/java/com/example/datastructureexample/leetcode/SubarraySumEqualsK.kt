package com.example.datastructureexample.leetcode

fun main(){

    val arr = arrayOf(1,2,2,2,4,5,6,7,2,2)
    val count = subarraySumEqualsK(arr,4)

    println(count)
}


fun subarraySumEqualsK(numbers : Array<Int>, k : Int) : Int {

    var count = 0
    var sum = 0

    val prefixedCount = mutableMapOf<Int, Int>()

    prefixedCount.put(0,1)

    for(num in numbers ){

        sum += num
        count += prefixedCount.getOrDefault(sum - k, 0)
        prefixedCount[sum] = prefixedCount.getOrDefault(sum, 0) + 1
    }

    return count
}