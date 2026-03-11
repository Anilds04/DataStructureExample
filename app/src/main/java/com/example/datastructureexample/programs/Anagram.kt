package com.example.datastructureexample.programs


/*You are given two strings s and t.

Goal: Determine if t is an anagram of s.

Anagram: Two strings have exactly the same characters with same frequency, possibly in a different order.

s = "listen", t = "silent" → true
s = "anagram", t = "nagaram" → true
s = "rat", t = "car" → false*/

fun main(){

    val result = isAnagramUsingGetOrDefault("listen","silent")
    println(result)
}

fun isValidAnagram(s: String, t: String) : Boolean {

    val result = IntArray(26)

    if(s.length != t.length)
        return false

    for(i in s.indices){

    }
    return false
}


fun isAnagramUsingGetOrDefault(a: String, b: String): Boolean {

    val s1 = a.replace(" ", "")
    val s2 = b.replace(" ", "")

    if(s1.length != s2.length) return  false

    val map = HashMap<Char, Int>()

    for ( c in s1){
        map[c] = map.getOrDefault(c, 0)+1
    }
    for ( c in s2){
        map[c] = map.getOrDefault(c, 0)-1
    }

    return map.values.all { it == 0 }

}
