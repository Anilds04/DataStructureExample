package com.example.datastructureexample.programs


fun main(){

    val fn = ::sum

    val result = mathOperation(10, 20, fn)
    println(result)

    //or

    val sub = mathOperation(20,5){a , b ->  a-b}
    println(sub)

    //lamda

    val sm = { a :Int, b: Int ->a+b}
    val sm1 = { a: Int  -> a+a}
}



fun sum(a : Int, b: Int) : Int{
    return a+b
}


fun mathOperation( a: Int, b :Int, fn:(Int, Int) -> Int) : Int{
    return fn(a, b)
}