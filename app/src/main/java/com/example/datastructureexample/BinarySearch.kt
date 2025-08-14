package com.example.datastructureexample


fun main(){

   // BinarySearch(arrayOf(1,4,6,8,9,12,34,56,78,99),1)

    val arr = arrayOf(1, 3, 5, 7, 9, 11, 13)
    println( binarySearchRecursive(arr, 193))
}

/*
* Iterative  method
* */
fun BinarySearch(array : Array<Int>, item : Int){

    var first = 0
    var last = array.size-1

    println("target = $item")

    while (first<=last) {

        println("while")

        var mid = (first+last)/2

        if (item == array[mid] ) {
            println("if")
            println("Found at $mid ${array[mid]}")
            return
        }
        if (item < array[mid]) {
            println("first $mid")
            last = mid-1
        }else{
            println("last $mid")
            first = mid+1
        }
    }
}

/*
* Recursive method
* */
fun binarySearchRecursive(array: Array<Int>, item: Int, first: Int = 0, last: Int = array.size - 1) : Int  {
   if (first > last) {
        println("Not found")
        return -1
    }
    val mid = (first + last) / 2

    println("Searching between $first and $last, mid=$mid (${array[mid]})")

    return when {
        item == array[mid] -> {
            println("Found at $mid (${array[mid]})")
            mid
        }
        item < array[mid] -> {
            binarySearchRecursive(array, item, first, mid - 1)
        }
        else -> {
            binarySearchRecursive(array, item, mid + 1, last)
        }
    }
}