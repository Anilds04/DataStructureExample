package com.example.datastructureexample.programs

fun main() {

    val result = isPalindrome("Test")
    val result1 = isPalindrome("Race car")
    val result2 = isPalindrome("A man, a plan, a canal: Panama")
    val result3 = isPalindrome("1221")

    println("$result")
    println("$result1")
    println("$result2")
    println("$result3")
}

fun isPalindrome(str: String): Boolean {
    var leftIndex = 0
    var rightIndex = str.length - 1

    while (leftIndex < rightIndex) {

        while ((leftIndex < rightIndex) && !str[leftIndex].isLetterOrDigit())
            leftIndex++

        while ((leftIndex < rightIndex) && !str[rightIndex].isLetterOrDigit())
            rightIndex--

        if (str[leftIndex].lowercase() != str[rightIndex].lowercase())
            return false

        leftIndex++
        rightIndex--
    }

    return true
}