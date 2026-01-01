package com.example.datastructureexample.programs


/*You are given two strings s and t.

Goal: Determine if t is an anagram of s.

Anagram: Two strings have exactly the same characters with same frequency, possibly in a different order.

s = "listen", t = "silent" → true
s = "anagram", t = "nagaram" → true
s = "rat", t = "car" → false*/

fun main(){

    val result = isValidAnagram("listen","silent")
}

fun isValidAnagram(s: String, t: String) : Boolean {

    val result = IntArray(26)

    if(s.length != t.length)
        return false

    for(i in s.indices){

    }
    return false
}


