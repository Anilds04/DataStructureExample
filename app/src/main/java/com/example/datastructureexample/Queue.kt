package com.example.datastructureexample


fun main() {
    val queue = Queue<Int>()
    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)

    println(queue.peek())    // Output: 10
    println(queue.dequeue()) // Output: 10
    println(queue.size())    // Output: 2
}


class Queue<T> {
    private val items = mutableListOf<T>()

    fun enqueue(item: T) {
        items.add(item)
    }

    fun dequeue(): T? {
        if (isEmpty()) return null
        return items.removeAt(0)
    }

    fun peek(): T? {
        return items.firstOrNull()
    }

    fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    fun size(): Int {
        return items.size
    }
}