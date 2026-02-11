package com.example.datastructureexample.ds.bst

fun main() {

    var root: Node? = null

    val arr = arrayOf(4, 6, 3, 7, 8, 10, 1, 2)
    for (a in arr) {
        root = insertIntoBST(root, a)

    }

    println(printBST(root))

    println(search(root, 11))
}


fun insertIntoBST(root: Node?, value: Int): Node {

    if (root == null)
        return Node(value)

    if (value < root.value)
        root.left = insertIntoBST(root.left, value)
    else
        root.right = insertIntoBST(root.right, value)

    return root
}


fun printBST(root: Node?) {
    if (root == null){
        print("${root?.value} ")
        return

    }

    printBST(root.left)
    print("${root.value} ")
    printBST(root.right)
}


//Check isAvailable

fun search(root : Node?, target : Int) : Boolean{

    if(root == null)
        return false

    if (root.value == target)
        return  true

    if(target < root.value)
        return search(root.left, target)
    else
        return search(root.right, target)


}


fun kthSmallest(root: Node?, k: Int): Int {
    val list = mutableListOf<Int>()

    fun inorder(node: Node?) {
        if (node == null) return
        inorder(node.left)
        list.add(node.value)
        inorder(node.right)
    }

    inorder(root)
    return list[k - 1]
}