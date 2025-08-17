package com.example.datastructureexample.programs


fun main(){

    /*

    with : if you want to operate on non-null object

    let : If you just want execute lamda expression
    on non nullable object and avoid Nullpointer

    run : if you want to operate on nullable object
    execute lamda expression and avoid Nullpointer

    apply : If you want to initialise or configure an object

    also : If you wan to do some additional object configuration or operation

    */

    val stdObj = Student()

    /*Scoped fun with
      Property 1 : Refer context object by using 'this'
      Property 1 : The return value is lamda result
     */

    val ageAfterFiveYears = with(stdObj){
        println(name)
        println(age)
        age+5
    }

    println("With:  Age after 5 years is $ageAfterFiveYears")


    /*Scoped fun with
        Property 1 : Refer context object by using 'this'
        Property 1 : The return value is the 'context object'
    */
    val emp = Emp().apply {
        name = "Employee 1"
        type ="Permanent"
    }

    with(emp){
        println(name)
        println(type)
    }

    /*Scoped fun also  ' ALSO PERFORM SOME EXTRA OPERATION'
        Property 1 : Refer context object by using 'it'
        Property 1 : The return value is the 'context object'
    */

    val number = mutableListOf(1,3,4,6,7)
    number.also {
        println("The number $it")
        it.remove(3)
        println("The number after remove $it")
    }

    emp.also {
        it.name = " Dera Updated"
        println(emp.name)
    }


    /*Scoped fun let
        Property 1 : Refer context object by using 'it'
        Property 1 : The return value is the 'lamda result'
    */

    val name : String? = "Hello"

    val length = name?.let {
        println(name.reversed())
        println(name.uppercase())
        name.length
    }



    /*Scoped fun run
        Property 1 : Refer context object by using 'this'
        Property 1 : The return value is the 'lamda result'
        run is a combination of with and let
        If you want to operate on nullable object use run
    */

    val std1 : Student? = Student()

    val s2 = std1?.run {
        std1.age
    }

    println(s2)

}


class Student{
    var name  = "Dera"
    val age = 1
}
data class Emp(var name : String = "", var type : String ="")