package com.example.datastructureexample.ds

fun main() {

    val treeNode = Node(50)

    treeNode.left = Node(40)
    treeNode.right = Node(70)

    treeNode.left?.left = Node(30)
    treeNode.left?.right = Node(45)

    treeNode.right?.left = Node(60)
    treeNode.right?.right = Node(80)

    println("Output is ${findClosest(treeNode, 35)}")
}


/* Creating BST Node*/
class Node(val value: Int) {
    var left: Node? = null
    var right: Node? = null
}


/* Search the closest in the BST*/
fun findClosest(node: Node?, target: Int): Int? {
    var currentNode = node

    if (currentNode == null)
        return null

    var closest = currentNode.value

    while (currentNode != null) {

        val value = currentNode.value
        if (Math.abs(value - target) < Math.abs(closest - target)) {
            closest = value
        }
        currentNode = if (target < value)
            currentNode.left
        else
            currentNode.right
    }
    return closest
}

/* Search for item in the BST*/
fun findIsAvailable(node: Node?, target: Int): Boolean {

    var isAvailable = false
    var currentNode = node

    while (currentNode != null) {

        val value = currentNode.value

        if (target == value) {
            isAvailable = true
            break
        }

        val leftDiff = currentNode.left?.value?.let {
            Math.abs(it - target)
        }

        val rightDiff = currentNode.right?.value?.let {
            Math.abs(it - target)
        }

        currentNode = when {
            leftDiff != null && (rightDiff != null && leftDiff < rightDiff) -> currentNode.left
            rightDiff != null -> currentNode.right
            else -> null
        }
    }
    return isAvailable
}