package com.example.datastructureexample.AbstactAndInterface



// why companion obj required why don't we add method in class itself
class MyClass{
    companion object A {

        fun test(){

        }

        fun done(){

        }
    }

    object B {

        fun add(){

        }
    }
}

fun main(){

    MyClass.test()
    MyClass.done()

    MyClass.B.add()

}