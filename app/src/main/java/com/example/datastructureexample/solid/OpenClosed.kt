package com.example.datastructureexample.solid

/*
O – Open/Closed Principle (OCP)

Definition:
Software entities should be open for extension, but closed for modification.*/

// ❌ Violates OCP: You need to change class every time you add new payment method
/*
class PaymentProcessor {
    fun pay(method: String) {
        if (method == "card") { */
/* card logic *//*
 }
        if (method == "paypal") { */
/* paypal logic *//*
 }
    }
}
*/



interface PaymentMethod{
    fun pay( amount: Double)
}


class CardPayment : PaymentMethod {
    override fun pay(amount: Double) = println("Paid $amount with Card")
}

class PayPalPayment : PaymentMethod {
    override fun pay(amount: Double) = println("Paid $amount with PayPal")
}

// Usage
fun processPayment(paymentMethod: PaymentMethod, amount: Double) {
    paymentMethod.pay(amount)
}