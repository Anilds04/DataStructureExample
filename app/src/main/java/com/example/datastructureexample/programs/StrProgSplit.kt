package com.example.datastructureexample.programs

fun main() {

    val sampleStr = """
 Pattern: pattern101
 Signal: sinx101
 Timing: 100
 Pattern: pattern102
 Signal:
 Timing: 600
 Pattern: pattern103
 Signal: sinx350
 Timing: 700
"""


    val lines_str = sampleStr.lines()

    for (line in lines_str) {

        if (line.contains("Pattern")) {

            val pattern = line.substringAfter(":").trim()
            println(pattern)
        }
        if (line.contains("Signal")) {
            val signal = line.substringAfter(":").trim()
            println(signal)
        }
        if (line.contains("Timing")) {
            val timing = line.substringAfter(":").trim()
            println(timing)
        }
    }
}