package com.example.datastructureexample.interview

data class Meeting(
    val title: String,
    val start: Int,
    val end: Int
)

/*
Return titles of meetings that overlap with ANY other meeting.
Sorted by start time.
*/
fun conflictingMeetings(meetings: List<Meeting>): List<String>{

    return emptyList()
}
