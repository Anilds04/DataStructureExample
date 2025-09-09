package com.example.datastructureexample.leetcode


fun main() {

    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)


    // connect neighbors
    node1.neighbors.add(node2)
    node1.neighbors.add(node4)
    node2.neighbors.add(node1)
    node2.neighbors.add(node3)
    node3.neighbors.add(node2)
    node3.neighbors.add(node4)
    node4.neighbors.add(node1)
    node4.neighbors.add(node3)


    // Clone the graph
    val cloned = cloneGraph(node1)


    // Print result
    println("Original node value: ${node1.value}, Cloned node value: ${cloned?.value}")
    println("Original neighbors: ${node1.neighbors.map { it?.value }}")
    println("Cloned neighbors: ${cloned?.neighbors?.map { it?.value }}")

    // Verify objects are different
    println("Original and cloned are same object? ${node1 === cloned}")

}

class Node(var value: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}


fun cloneGraph(node: Node?): Node? {
    if (node == null)
        return null

    val map = mutableMapOf<Node, Node>()

    fun dfs(n: Node): Node {

        if (map.containsKey(n))
            return map[n]!!

        val copy = Node(n.value)
        map[n] = copy

        for (nei in n.neighbors) {
            if (nei != null)
                copy.neighbors.add(dfs(nei))

        }

        return copy
    }


    return dfs(node)
}


