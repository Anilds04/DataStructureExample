package com.example.datastructureexample.interview

import java.util.PriorityQueue



/*Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of meeting rooms required to schedule all meetings without any conflicts.

Note: (0,8),(8,10) is not considered a conflict at 8.

Example 1:

Input: intervals = [(0,40),(5,10),(15,20)]
Output: 2

Explanation:
meeting room 1: (0,40)
meeting room 2: (5,10),(15,20)

Example 2:

Input: intervals = [(4,9)]

Output: 1
Constraints:

0 <= intervals.length <= 500
0 <= intervals[i].start < intervals[i].end <= 1,000,000 */

//Input: intervals = [(0,10),(2,6),(4,8),(5,20),(15,20)]



fun main() {

    val intervals = arrayOf(
        intArrayOf(0, 10),
        intArrayOf(2, 6),
        intArrayOf(4, 8),
        intArrayOf(5, 20),
        intArrayOf(15, 20)
    )

    val result = minMeetingRooms(intervals)
    print(result)
}


fun minMeetingRooms(intervals : Array<IntArray> ) : Int{

    if(intervals.isEmpty()) return 0

    //Sort meetings by start time
    intervals.sortBy { it[0]}

    //Min heap to store end times
    val pq = PriorityQueue<Int>()

    var maxRooms = 0

    for (meeting in intervals){

        val start = meeting[0]
        val end = meeting[1]

        // 3. Free all rooms that have finished
        while(pq.isNotEmpty() && start >= pq.peek()){
            pq.poll()
        }

        pq.add(end)

        maxRooms = maxOf(maxRooms, pq.size)
    }

    return maxRooms
}