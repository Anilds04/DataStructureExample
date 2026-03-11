package com.example.datastructureexample.solid

/*S – Single Responsibility Principle (SRP)

Definition:
A class should have only one reason to change. It should do one thing, and one thing only.*/

// ❌ Violates SRP: Handles both network and logging
/*
class UserRepository {
    fun fetchUser() {
        // fetch from network
        println("User fetched")  // logging
    }
}
*/


class UserRepository {
    fun fetchUser(): User {
        // fetch user from network or DB
        return User("Alice")
    }
}

class Logger {
    fun log(message: String) {
        println(message)
    }
}

// Usage
/*
val userRepo = UserRepository()
val user = userRepo.fetchUser()
Logger().log("Fetched user: ${user.name}")*/


data class User(val name : String)