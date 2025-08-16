package com.example.datastructureexample.sorting




fun main(){

    val selectionSort = SelectionSort(arrayOf(10,6,18,2,9,4,89,7,13))
    selectionSort.sort()

}
class SelectionSort( val array: Array<Int> ) {

    fun sort(){

        val n = array.size
        for (i in 0 until n){

           var minIndex  = i

            for (j in i+1 until array.size){

                //swap
                if(array[j] < array[minIndex]){
                   minIndex = j
                }

            }

            if(minIndex != i){
                var temp = array[minIndex]
                array[minIndex] = array[i]
                array[i] = temp
            }
        }

        println(array.joinToString())
    }
}