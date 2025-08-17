package com.example.datastructureexample.programs

class GenericsExample<T> (var data :T){
    fun setValue(value: T){
        data = value
    }

    fun getValue() :T{

        return data
    }
}


class GenericsExample2<T> {

    private var storedValue: T? = null

    fun setValue(value: T) {
        storedValue = value
    }

}

fun main(){
    val gen1 = GenericsExample(5)
    println( gen1.getValue())

    gen1.setValue(6)
    println(gen1.getValue())


    val gen2 = GenericsExample("hello")
    println(gen2.getValue())

    val gen3 = GenericsExample2<Int>()
    gen3.setValue(6)

}