package com.example.datastructureexample.slidingwindow

import kotlin.math.max


fun main() {


    val sum = maximumSubarraySum(intArrayOf(1, 5, 4, 2, 9, 9, 9), k = 3)
    println(sum)
}

fun maximumSubarraySum(nums: IntArray, k: Int): Long {

    var maxSum: Long = 0
    var windowSum: Long = 0
    var left = 0
    var seen = HashSet<Int>()

    for (right in nums.indices) {


        while (nums[right] in seen){
            seen.remove(nums[left])
            windowSum -= nums[left]
            left++

        }

        windowSum += nums[right]
        seen.add(nums[right])


        if (right - left + 1 == k){
            maxSum = max(maxSum, windowSum)

            seen.remove(nums[left])
            windowSum -= nums[left]
            left++
        }

    }

    return maxSum
}