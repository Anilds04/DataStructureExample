package com.example.datastructureexample.programs

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{

    val TAG = "Coroutine Scope"

   val job = CoroutineScope(Dispatchers.IO).launch {
        delay(1000)
        println(" ${Thread.currentThread()}")
    }
  /* CoroutineScope(Dispatchers.Main).launch {
        delay(1000)
        Log.d(TAG, "main: ${Thread.currentThread()}")
    }*/
    val job2 = CoroutineScope(Dispatchers.Default).launch {
        delay(1000)
        println(" ${Thread.currentThread()}")
    }

    job.join()
    job2.join()

    val job3 = CoroutineScope(Dispatchers.Default).async {
        delay(1000)
        println(" ${Thread.currentThread()}")
        42
        "df"

    }

    job3.join()
    println(job3.await())



    /*val jb2= GlobalScope.launch {
        delay(1000)
        println(" ${Thread.currentThread()}")
    }*/

  /*  val jb3 = MainScope().launch {
        delay(1000)
        println(" ${Thread.currentThread()}")
    }

    jb3.join()
    jb2.join()*/
}