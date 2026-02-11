package com.example.datastructureexample.interview


/*

Each event has a start time, end time, and a title. Your task: Given a current time and a list of events,

you need to: Filter out events that end before the current time (i.e., completely in the past).

Sort the remaining events by their start time. Detect overlaps between events.

If an event overlaps with any other event in the filtered, sorted list, mark it by appending " (Overlap)" to its title.

Return a List<String> representing the final list of event titles, in sorted order.
*/


data class Event(
    val title: String,
    val startTime: Long,
    val endTime: Long
)

class ScheduleUsecase {

    fun prepareSchedule(events: List<Event>, currentTime: Long): List<String> {

        // 1. Filter out past events and sort by start time
        val upcomingEvents = events
            .filter { it.endTime > currentTime }
            .sortedBy { it.startTime }

        // 2. Track which events overlap
        val hasOverlap = BooleanArray(upcomingEvents.size)

        for (i in 0 until upcomingEvents.size - 1) {
            val current = upcomingEvents[i]
            val next = upcomingEvents[i + 1]

            // Correct overlap condition
            if (current.startTime < next.endTime &&
                current.endTime > next.startTime
            ) {
                hasOverlap[i] = true
                hasOverlap[i + 1] = true
            }


        }

        // 3. Build final result
        return upcomingEvents.mapIndexed { index, event ->
            if (hasOverlap[index]) "${event.title} (Overlap)"
            else event.title
        }
    }
}

fun main() {
    val currentTime = 10L
    val events = listOf(
        Event("Coffee Break", 8, 9),
        Event("Morning Meeting", 9, 11),
        Event("Code Review", 10, 12),
        Event("Lunch Break", 12, 13),
        Event("Afternoon Sync", 14, 15)
    )

    val result = ScheduleUsecase().prepareSchedule(events, currentTime)
    println(result)
}