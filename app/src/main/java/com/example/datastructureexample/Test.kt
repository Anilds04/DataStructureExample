package com.example.datastructureexample

fun main(){

    //Calling Lamda
    println(greet_lamda("ANil"))

    //Calling higher order fun
    val nam = greet_higher("Ani"){
        it
    }
}


val greet_lamda :(String) -> String = { "Greet user $it"}


fun greet_higher(name: String, action : (String) -> String) :String{
    return action(name)
}