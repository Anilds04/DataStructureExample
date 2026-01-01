package com.example.datastructureexample.slidingwindow

import kotlin.math.max

fun main() {
    val maxLength = dummy("abcbbabefghi")
    println(maxLength)
}


//Method 1
fun lengthOfLongestSubstring(s: String): Int {

    var maxLen = 0
    var left = 0
    val seen = mutableSetOf<Char>()

    for (right in s.indices) {

        while (s[right] in seen) {
            seen.remove(s[left])
            left++
        }

        seen.add(s[right])
        maxLen = max(maxLen, (right - left + 1))
    }

    return maxLen
}

//Method 2

fun lengthOfLongestSubstring1(s: String): Int {
    val last = HashMap<Char, Int>() // stores last seen index of each char
    var left = 0                    // start of current window
    var best = 0                    // max length of substring found

    for ((right, ch) in s.withIndex()) {
        // Check if the character was seen inside the current window
        val prev = last[ch]
        println("$prev")
        if (prev != null && prev >= left) {
            println("$prev and $left")
            left = prev + 1       // jump just past the previous occurrence
        }
        last[ch] = right           // update last seen index
        best = maxOf(best, right - left + 1)  // update max length
    }

    return best
}


    fun dummy(s: String): Int {




        var left = 0
        var maxLen = 0

        var set = HashSet<Char>()


        for (right in s.indices) {

            while (set.contains(s[right])) {
                set.remove(s[left])
                left++
            }

            set.add(s[right])
            maxLen = maxOf(right-left+1, maxLen)

        }

        return maxLen
    }