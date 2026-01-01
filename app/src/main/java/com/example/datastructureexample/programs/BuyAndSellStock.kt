package com.example.datastructureexample.programs

fun main(){

    val result = maxProfit(intArrayOf(1,5,8,6,7,9))
    println(result)
}


fun maxProfit( prices : IntArray) : Int{

    var minPrice = Int.MAX_VALUE
    var maxProfit = 0

    for (price in prices){
        minPrice = minOf(price, minPrice)
        maxProfit = maxOf(maxProfit, price- minPrice)
    }

 return maxProfit
}