package com.example.datastructureexample.lamdaDemo

fun main() {

    val s = ::sum

    //calling calculator
    val cal = calculator(10, 20, s)

    val car2 = calculator(20, 50) { a, b ->
        a + b
    }
  //  println(car2)

}


fun sum(a: Int, b: Int): Int {

    return a + b
}

fun calculator(p: Int, q: Int, gn: (Int, Int) -> Int) {

    println(gn(p, q))
}