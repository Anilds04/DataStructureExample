package com.example.datastructureexample.searching



fun main(){

    linearSearch(arrayOf(2,9,3,4,7,6,3,5), 3)

}


fun linearSearch (arr : Array<Int>, target : Int){

    for(i in arr.indices){
        if(arr[i] == target)
        {
            println("Item $target found in index $i")
            break
        }
    }
}