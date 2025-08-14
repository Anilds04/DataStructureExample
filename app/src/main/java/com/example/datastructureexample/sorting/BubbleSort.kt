package com.example.datastructureexample.sorting



fun main(){

    /*Can also create method and call don;'t need class */
   // bubbleSort(arrayOf(5,4,8,9,7,4,3,1))
    val sort = BubbleSort(arrayOf(5,4,8,9,7,4,3,1))
    sort.bubbleSort()
}


class BubbleSort(val array: Array<Int>) {
    fun bubbleSort() {

        for (i in array.indices) {

            for (j in array.indices) {

                if (array[i] < array[j]) {
                    var temp = array[i]
                    array[i] = array[j]
                    array[j] = temp
                }
            }
        }

        println(array)
    }
}