package com.example.datastructureexample.programs

fun main(){

   val sumArray =  twoSum(intArrayOf(2,5,7,9,0), 20)

    println(sumArray.joinToString())
}


fun twoSum(nums : IntArray, target : Int) : IntArray{

    val map = HashMap<Int, Int>()

    for (i in nums.indices){
        val diff = target - nums[i]
        if(map.contains(diff)){
            return intArrayOf(map[diff]!!, i)
        }

        map[i] = i

        println(map)
    }
    return intArrayOf()
}

