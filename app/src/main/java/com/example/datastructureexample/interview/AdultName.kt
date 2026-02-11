package com.example.datastructureexample.interview


data class User(val name: String, val age: Int)


/*
Return names of adults (age ≥ 18), sorted by age.
*/
fun adultNames(users: List<User>): List<String> {

    return users.filter { it.age >= 18 }
        .sortedBy { it.age }
        .map {
            it.name
        }


}


fun main() {


    val users = listOf(
        User(name = "Alice", age = 17),   // minor (excluded)
        User(name = "Bob", age = 18),     // adult (edge case)
        User(name = "Charlie", age = 25), // adult
        User(name = "Diana", age = 16),   // minor (excluded)
        User(name = "Eve", age = 30),     // adult
        User(name = "Frank", age = 18)    // adult (same age as Bob)
    )

    val result = adultNames(users)
    println(result)
}