package com.example.datastructureexample.sorting



fun main(){

    /*Can also create method and call don;'t need class */
   // bubbleSort(arrayOf(5,4,8,9,7,4,3,1))
    val sort = BubbleSort(arrayOf(5,4,8,9,7,4,3,1))
    sort.bubbleSort()
}


class BubbleSort(val array: Array<Int>) {
    fun bubbleSort() {

        for (i in 0 until array.size-1) {

            for (j in 0 until array.size -i-1) {

                if (array[j] > array[j+1]) {
                    var temp = array[j+1]
                    array[j+1] = array[j]
                    array[j] = temp
                }
            }
        }

        println(array.joinToString())
    }
}