package com.example.datastructureexample.programs

fun main() {

    numberReverse(345)
    StringReverse("Dera")
}


fun StringReverse(str: String) {

    var result : String = ""
    for(i in str.length-1 downTo 0){

        result +=str[i]
    }
    println(result)
}

fun numberReverse(data: Int) {
    var num = data
    var rev = 0
    var r = 0

    while (num > 0) {
        r = num % 10
        rev = (rev * 10) + r
        num /= 10
    }

    println(rev)
}