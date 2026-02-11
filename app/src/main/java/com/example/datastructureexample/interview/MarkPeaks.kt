package com.example.datastructureexample.interview

/*
Given a list of integers, return a list of strings.
If a number is greater than BOTH its neighbors, mark it as " (Peak)".

First and last elements can never be peaks.
*/


fun main() {
    val input = listOf(1, 3, 2, 5, 4, 6, 1)
    val result = markPeaks(input)

    print(result)
}

fun markPeaks(nums: List<Int>): List<String> {


    val isPeak = BooleanArray(nums.size)


    for (i in 1 until nums.size - 1) {
        val previous = nums[i - 1]
        val next = nums[i + 1]
        val current = nums[i]

        if (previous < current && current > next) {
            isPeak[i] = true
        }
    }

    val data = nums.mapIndexed { index, num ->
        if (isPeak[index]) {
            "$num (Peak)"
        } else
            "$num"

    }

    return data
}