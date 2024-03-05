package SortingAlgorithms

import java.util.*

fun main() {
    val input = arrayOf(4, 3, 6, 7, 1,5 ,2)
    val selectionSort = SelectionSort()
    println(Arrays.toString(selectionSort.sortAscending(input)))
    println(Arrays.toString(selectionSort.sortDescending(input)))
}

/**
 * Find the min/max element from the array and swap it with first unsorted index in the array
 */
class SelectionSort {

    /**
     * Int i = outerLoop index Int j = innerLoop index
     * step1: traverse through array from i = 0 to size-1 and assign minIndex to i
     * step2: traverse  from j =i+1 to size-1 and if input[j] < input[minIndex] assign minIndex to j
     * step 3  if minIndex != i then swap element of input[i] with input[minIndex]
     */
    fun sortAscending(input: Array<Int>):Array<Int> {
        for(i in 0 until input.size) {
            var minIndex = i
            for(j in i+1 until  input.size) {
                if(input[j]<input[minIndex]) {
                    minIndex = j
                }
            }
            if(minIndex != i) {
                val temp = input[i]
                input[i] = input[minIndex]
                input[minIndex] = temp;
            }
        }
        return input
    }

    /**
     * Int i = outerLoop index Int j = innerLoop index
     * step1: traverse through array from i = 0 to size-1 and assign maxIndex to i
     * step2: traverse  from j =i+1 to size-1 and if input[j] > input[maxIndex] assign maxIndex to j
     * step3  if maxIndex != i then swap element of input[i] with input[maxIndex]
     */
    fun sortDescending(input: Array<Int>):Array<Int> {
        for(i in 0 until input.size-1) {
            var maxIndex = i
            for(j in i+1 until  input.size) {
                if(input[j]>input[maxIndex]) {
                    maxIndex = j
                }
            }
            if(maxIndex != i) {
                val temp = input[i]
                input[i] = input[maxIndex]
                input[maxIndex] = temp;
            }
        }
        return input
    }
}