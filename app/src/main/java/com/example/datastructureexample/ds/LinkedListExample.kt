package com.example.datastructureexample.ds



fun main(){

    val list = LinkedList<Int>()


    list.insert(10)
    list.insert(0)
    list.insert(1)
    list.insert(2)
    list.insert(55)


    list.printList()


    list.delete(1)
    list.delete(6)

    list.printList()

    list.reverseList()

    list.printList()
}


class Node1<T>(var data :T){
    var next : Node1<T>? =null
}


class LinkedList<T> {

    private var head : Node1<T>? =null

    fun isEmpty() : Boolean = head == null

    fun insert(data :T){
        val newNode = Node1(data)
        if(head == null){
            head = newNode
        }
        else{
            var current = head
            while (current?.next != null){
                current = current.next
            }
            current?.next = newNode
        }
    }


    fun delete(data: T){
        if(head == null) return

        if (head?.data ==data){
            head = head?.next
            return
        }

        var current = head
        while(current?.next != null){
            if(current.next?.data == data){
                current.next =  current.next?.next
                return
            }
            current = current.next

        }
    }


    fun printList(){
        var current = head
        while (current != null){
            print("${current.data} -> ")
            current = current.next
        }
        println("null")
    }

    fun reverseList() : Node1<T>?{
        var prev : Node1<T>? = null
        var current = head

        while (current != null){
            val next = current.next
            current.next = prev
            prev = current
            current =next
        }
        head = prev
        return prev
    }

}
