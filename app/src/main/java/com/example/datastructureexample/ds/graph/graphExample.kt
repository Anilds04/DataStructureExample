package com.example.datastructureexample.ds.graph

fun main() {

    val n = 4
    val graph = Array(n) { mutableListOf<Int>() }

    /*It looks like below
    graph[0] -> []
    graph[1] -> []
    graph[2] -> []
    graph[3] -> []*/


    graph[0].add(1)
    graph[0].add(2)

    graph[1].add(0)
    graph[1].add(3)

    graph[2].add(0)
    graph[2].add(3)

    graph[3].add(1)
    graph[3].add(2)


  /*  for (i in 0 until n) {
        println("$i  -> ${graph[i]}")
    }*/

    bfsTraversal(graph, 0)
    shortestPath(graph, 0)
}

fun bfsTraversal(graph: Array<MutableList<Int>>, start: Int) {

    val n = graph.size
    val visited = BooleanArray(n)
    val queue = ArrayDeque<Int>()

    visited[start] = true
    queue.add(start)

    while (queue.isNotEmpty()){
        val node = queue.removeFirst()
        println(node)

        for ( neighbours in graph[node]){
            if (!visited[neighbours]){
                visited[neighbours] = true
                queue.add(neighbours)
            }
        }

    }

}


fun shortestPath(graph: Array<MutableList<Int>>, start: Int) {

    val n = graph.size
    val distance = IntArray(n){-1}
    val queue = ArrayDeque<Int>()

    distance[start] = 0
    queue.add(start)

    while (queue.isNotEmpty()){
        val node = queue.removeFirst()
    //    println(node)

        for ( neighbours in graph[node]){
            if (distance[neighbours] == -1){
                distance[neighbours] = distance[node]+1
                queue.add(neighbours)
            }
        }

    }

   // println(distance)

    for (i in 0 until n) {
        println("0 -> $i = ${distance[i]}")
    }
}


