package com.example.datastructureexample

fun main() {

    val stack =  Stack<Int>()

    stack.push(10)
    stack.push(1)
    stack.push(13)
    stack.push(15)
    stack.push(19)


    println(stack.peek())  // Output: 19

    println(stack.pop())   // Output: 19
    println(stack.pop())   // Output: 15

    println(stack.size())  // Output: 3
}

class Stack<T> {

    private val list = mutableListOf<T>()

    fun push(value: T) {
        list.add(value)
    }

    fun pop(): T? {
        if (isEmpty())
            return null

        return list.removeAt(list.size - 1)
    }
    fun peek(): T? {
        if (isEmpty())
            return null

        return list[list.size - 1]
    }

    fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    fun size(): Int {
        return list.size
    }
}