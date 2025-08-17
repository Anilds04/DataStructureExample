package com.example.datastructureexample

import com.example.datastructureexample.programs.factIterative
import com.example.datastructureexample.programs.factRecursive
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class FactorialTesting {

    @Test
    fun fact_test_expected_correct(){

        //AAA arrange act assert

        // Capture the output this is because we are not returning the value
        val outputStream = ByteArrayOutputStream()
        val printStream = PrintStream(outputStream)
        val originalOut = System.out
        System.setOut(printStream)


       factIterative(5)

        // Restore original System.out
        System.setOut(originalOut)
        val printed = outputStream.toString().trim() // remove newline
        assertEquals(120,printed.toInt())
    }


    @Test
    fun fact_test_expected_correct_recursive(){
        //AAA arrange act assert
        val result =  factRecursive(5)
        assertEquals(120,result)
    }
}