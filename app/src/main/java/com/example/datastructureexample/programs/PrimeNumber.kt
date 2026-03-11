package com.example.datastructureexample.programs

fun main() {

    val number = readLine()?.toIntOrNull() ?: 0

    for (i in 2 until number) {
        if (isPrimeNumber(i))
            println(i)
    }


}


fun isPrimeNumber(number: Int): Boolean {

    if (number <= 1) return false

    if (number == 2) return true

    val mid = kotlin.math.sqrt(number.toDouble()).toInt()

  //  val mid = number / 2

    for (i in 2..mid) {
        if (number % i == 0)
            return false
    }

    return true
}