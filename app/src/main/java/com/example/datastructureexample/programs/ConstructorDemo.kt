package com.example.datastructureexample.programs

//Primary
class ConstructorDemo(val name : String, val age : Int) {




}

//Secondary
class ConstructorDemo1(val name : String, val age : Int) {

    constructor( name : String) : this(name, 10)


}


//Default
class ConstructorDemo3 {

    fun demo(){

    }


}


fun main(){

    val con = ConstructorDemo("Test" , 10)
    val con1 = ConstructorDemo1("Test" )
    val con3 = ConstructorDemo3()
}