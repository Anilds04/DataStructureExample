package com.example.datastructureexample.interview

import kotlin.math.abs


fun main() {

    val result = markLargeJumps(listOf(1, 2, 7, 3, 4, 10))
    println(result)
}


fun markLargeJumps(nums: List<Int>): List<String> {

    val jumpArray = BooleanArray(nums.size)

    for (i in 0 until nums.size) {
        when {
            i == 0 -> if (abs(nums[i] - nums[i + 1]) > 3)
                jumpArray[i] = true

            i == nums.lastIndex -> if (abs(nums[i] - nums[i - 1]) > 3)
                jumpArray[i] = true

            else ->
                if (abs(nums[i] - nums[i + 1]) > 3 &&
                    abs(nums[i] - nums[i - 1]) > 3)
                    jumpArray[i] = true
        }
    }

    return nums.mapIndexed { index, i ->
        if(jumpArray[index])
            "$i (jump)"
        else
            "$i"
    }
}