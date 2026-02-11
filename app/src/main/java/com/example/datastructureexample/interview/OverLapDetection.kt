package com.example.datastructureexample.interview

data class Event3(val start: Int, val end: Int)

/*
Return true if ANY two Event3s overlap.
Otherwise return false.
*/
fun hasOverlap(Event3: List<Event3>): Boolean{

    return false
}

fun main() {

    val allTestEvent3s = listOf(
        // Case 2: No overlap, back-to-back
        Event3(1, 3),
        Event3(3, 6),

        // Case 4: No overlap, unsorted
        Event3(10, 12),
        Event3(7, 9),
        Event3(4, 5),

        // Case 1: Simple overlap
        Event3(2, 5),
        Event3(4, 8),   // overlaps with (2,5)

        // Case 5: Exact same time range
        Event3(6, 10),
        Event3(6, 10),

        // Case 6: Single Event3
        Event3(15, 20)
    )

    hasOverlap(allTestEvent3s)
}