package com.example.datastructureexample.solid

/*
L – Liskov Substitution Principle (LSP)

Definition:
Objects of a superclass should be replaceable with objects of a subclass without breaking the program.*/


/*
open class Payment {
    open fun refund() {
        println("Refund processed")
    }
}

class CashOnDelivery : Payment() {

    override fun refund() {
        throw Exception("COD cannot refund online")
    }
}*/


//payment can be either class or interface

/*interface Payment {
    fun pay()
}*/
open class Payment {
    open fun pay(){

    }
}

interface Refundable {
    fun refund()
}

class CardPayment1 : Payment(), Refundable {

    override fun pay() {
        println("Card payment")
    }

    override fun refund() {
        println("Refund to card")
    }
}

class CashOnDelivery : Payment() {

    override fun pay() {
        println("COD payment")
    }
}