package com.example.datastructureexample.programs

fun main(){

    val userList = listOf(
        User(1, "abc", true),
        User(1, "efg", false),
        User(1, "hij", false),
        User(1, "okl", true),
        User(1, "gjg", true),
        User(1, "aofobc", false),
        User(1, "kgg", true)
    )


    println(userList.first())
    val activeUser = userList.filter { it.active }
    println(activeUser)

    val activeUserName = userList.filter { it.active }.map { it.name }
    println(activeUserName.toSet())
    println(userList)

    // Map from user id to user
    val userMap: Map<Int, User> = userList.associateBy { it.id }
    println(userMap[3]?.name)  // "Charlie"
}


data class User(val id :Int, val name : String, val active :Boolean)

