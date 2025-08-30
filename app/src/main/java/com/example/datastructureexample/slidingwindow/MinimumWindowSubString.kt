package com.example.datastructureexample.slidingwindow

fun main() {

    minimumWindowSubString("ADOBECODEBANC", "ABC")
}


fun minimumWindowSubString(s: String, t: String): String {

    if (s.isEmpty() || t.isEmpty()) return ""

    val required = mutableMapOf<Char, Int>()
    for (ch in t)
        required[ch] = required.getOrDefault(ch, 0) + 1


    var left = 0
    var right = 0
    var formed = 0
    var windowCount = mutableMapOf<Char, Int>()
    var minLen = Int.MAX_VALUE
    var minLeft = 0


    while (right < s.length) {
        val c = s[right]
        windowCount[c] = windowCount.getOrDefault(c, 0) + 1

        if (required.containsKey(c) && windowCount[c] == required[c]) {
            formed++
        }

        while (left <= right && formed == required.size) {

            if (right - left + 1 < minLen) {
                minLen = right - left + 1
                minLeft = left
            }

            val cl = s[left]
            windowCount[cl] = windowCount[cl]!! - 1
            if (required.containsKey(cl) && windowCount[cl]!! < required[cl]!!) {
                formed--
            }
            left++
        }

        right++
    }

    println("$minLeft, ${minLeft+minLen}")

    return if (minLen == Int.MAX_VALUE) "" else s.substring(minLeft, minLeft + minLen)
}