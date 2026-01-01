package com.example.datastructureexample.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {


    val num = 2.345676
    println(String.format("%.2f", num))


    runBlocking {
       val (user , posts ) =  fetchUserAndPosts()
        println("User  $user")
        println("Posts  $posts")
    }



}

data class User(val id: Int, val name: String)

data class Post(val id: Int, val content: String)


suspend fun fetchUser(): User {

    delay(2000)
    return User(1, "Anil")
}


suspend fun fetchPosts(): Post {

    delay(3000)
    return Post(1, "I am a dancer")
}


suspend fun fetchUserAndPosts(): Pair<User, Post> = coroutineScope {

    val userjob = async { fetchUser() }
    val postjob = async { fetchPosts() }

    userjob.await() to postjob.await()
}
