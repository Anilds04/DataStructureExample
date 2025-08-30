package com.example.datastructureexample.slidingwindow

import kotlin.math.max


fun main(){

    val obj = MaximumSumSubarrayOfSizeK()

    val sum = obj.maxSubArray(intArrayOf(1,5,4,2,9,9,9), k = 3)
    println(sum)
}
class MaximumSumSubarrayOfSizeK {

    fun maxSubArray(nums: IntArray, k: Int): Int {
        var maxSum = 0
        var windowSum = 0

        for (i in 0 until k){
            windowSum += nums[i]
        }

        maxSum = windowSum

        for(j in k until nums.size){

            windowSum += nums[j] -nums[j-k]

            maxSum = max(windowSum, maxSum)
        }

        return maxSum
    }
}