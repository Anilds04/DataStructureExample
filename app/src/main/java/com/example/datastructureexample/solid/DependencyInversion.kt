package com.example.datastructureexample.solid

/*
Dependency Inversion Principle (DIP)

Definition:
High level classes should depend on abstractions, not concrete implementations.*/


/*
class MySQLDatabase {
    fun saveUser() {
        println("Saved in MySQL")
    }
}

class UserService {

    private val db = MySQLDatabase()

    fun registerUser() {
        db.saveUser()
    }
}
*/


interface Database{
    fun saveUser()
}

class MySQLDatabase : Database{
    override fun saveUser() {
    }
}


class Firebase : Database{
    override fun saveUser() {
    }
}


class UserService(val database: Database){

    fun register(){
        database.saveUser()
    }

}