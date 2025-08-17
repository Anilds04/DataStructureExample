package com.example.datastructureexample.programs


fun main(){


    //Apply
    val emp = Emp()
    emp.apply {
        emp.name = "Test"
        emp.type ="Permanent"
    }
    println(emp.name)


    val empLet = emp.let {
        println(it.type)
        "This value will  be assigned to empLet"
    }

    println(empLet.toString())

    val emp3 = with(emp){
        name = "Test3"
        "I will return"
    }

    println(emp3)
}

data class Emp(var name : String = "", var type : String ="")