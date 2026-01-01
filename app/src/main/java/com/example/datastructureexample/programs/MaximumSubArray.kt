package com.example.datastructureexample.programs

fun main(){

    val result = maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))
    println(result)
}


fun maxSubArray(nums : IntArray) : Int{

    var currentSum = nums[0]
    var maxSum = nums[0]

    for (i in 1 until nums.size){
        currentSum = maxOf(nums[i], currentSum+nums[i])
        maxSum = maxOf(currentSum, maxSum)
    }

    return maxSum
}