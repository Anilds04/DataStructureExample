package com.example.datastructureexample.let


fun main() {


    // basic()
    // nestedNullable()
    // returningValues()
    // transformation()
    // avoidShadowing()
    //chaining()
    //multipleNullable()
    //sideEffects()
    //letAndAlso()
    //elvisOperator()
    //deStructuring()
    //localScopeTick()
    //builderStyle()
    doubleNullSafety()

}


/*Explanation: You can nest let blocks to only execute when both values are non-null. Otherwise, Elvis ?: provides a default.*/

fun doubleNullSafety(){

    val token : String? = "abc"
    val user : String? =null

    val result = token?.let { t ->
        user?.let {u ->
            "Token $t and $ $u"
        }
    } ?: "Missing data"

    println(result)
}

/*Explanation: Use let to build objects step by step and return a final transformed result (String).*/

fun builderStyle(){

    val sb = StringBuilder().let {
        it.append("hel")
        it.append("to")
        it.toString()
    }
    println(sb)
    //or

    val bs = buildString {
        append("new")
        append("method")
    }

   println(bs)
}

/*Explanation: let creates a temporary scope, useful for avoiding extra variables leaking outside.*/
fun localScopeTick(){

    val name = run {
        val name = "tsts"
        name.let {
            it.uppercase()
        }
    }

    println(name)
}

/*Explanation: Inside let, you can destructure data classes. it is unpacked into n and a.*/
fun deStructuring(){

    val user = User("ANil", Address("India"))

    user.let {(n, a) ->
        println(n)
        println(a?.city)
    }
}

/*Explanation: If name is non-null, return its length. Otherwise (null), Elvis operator provides -1.*/
fun elvisOperator(){

    val name : String? = null
    val length = name?.let { it.length } ?: -1
    println(length)
}


/*let returns block result (transformed string). also returns the original object, good for debugging.*/
fun letAndAlso(){

    val token = "Token".let { "Bearer $it" }
    val token2 = "Token".also { println(it) }
    println(token)
    println(token2)
}

/*Explanation: Use let for temporary side effects like logging while still returning the original value.*/
fun sideEffects(){

    val token = "side".let {
        println("side effect $it")
        it
    }

    println(token)
}

/*Explanation: Nested let safely combines two nullable values without explicit null checks.*/
fun multipleNullable(){

    val a : String? = "foo"

    val b :  String ? = "bar"

    a?.let {
        b?.let{
            println("$a $b")
        }
    }
}

/*Explanation: Multiple let calls can be chained. Each block transforms the result of the previous one.*/
fun chaining() {

    val name = "new"

    val upperName = name.
    let { it.uppercase().
    let { "Result $it" } }

    println(upperName)
}

/*Explanation: If a local variable name clashes, rename inside let (t) to avoid confusion.*/
fun avoidShadowing() {

    val token = "token"

    val bearerToken = token.let { t -> "Bearer $t" }
    println(bearerToken)
}


/*Explanation: let transforms a nullable String into a nullable Int. If number is null → block won’t run.*/
fun transformation() {
    val name: String? = "10"

    val num = name?.let { it.toInt() }
    println(num)

}

fun basic() {

    val name: String? = "test"

    /* Here, let is only executed if name is non-null.*/
    name?.let {
        println(it)
    }

}

/*Explanation: let returns the last expression. With ?.let, you can combine with ?: (Elvis) for null-safety.*/
fun returningValues() {


    val length = "Test".let { it.length }
    println(length)

    val name: String? = null

    val leg = name?.let { it.length } ?: 0
    println(leg)
}

/*Explanation: Instead of nested null checks, chaining ?.let allows safe access to city. If user or address is null → block won’t run..*/
fun nestedNullable() {


    val user: User? = User("anil", Address("India"))

    user?.let {
        println(it.name)
        println(it.address?.city)
    }

    //or

    user?.address?.city.let {
        println(it)
    }
}

data class Address(val city: String?)

data class User(val name: String, val address: Address?)