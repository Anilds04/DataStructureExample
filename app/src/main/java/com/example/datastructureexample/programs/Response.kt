package com.example.datastructureexample.programs

sealed class Response <T>(val message : T? = null, val error : T? = null){

    class Success<T>(message : T? = null) : Response<T>(message = message)
    class Error<T>(error: T? = null) : Response<T>(error = error)
    class Loading<T>() : Response<T>()
}



fun main(){

    val success = Response.Success("I am here")

  /*  when(success){
        is Response.Success -> {println("This is success method")}

        is Response.Error-> {println("This is error")}
        else -> {

        }
    }*/

}