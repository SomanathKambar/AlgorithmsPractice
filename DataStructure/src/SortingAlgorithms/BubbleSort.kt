package SortingAlgorithms

fun main(){
    val bubbleSort = BubbleSort()
    val input = arrayOf(1, 4, 5 , 3, 7 , 2,6)
    println(bubbleSort.sortAscending(input).contentToString())
    println(bubbleSort.sortDescending(input).contentToString())
}
class BubbleSort { ////-->  O(n)^2
    fun  sortAscending(input: Array<Int>) : Array<Int> {
        val len = input.size //-->  O(1)
        for(i in 0..len-1) { //-->  O(n)
            for(j in 0 until len-i-1) {//-->  O(n)
                if(input[j] > input[j+1]) {//-->  O(n)
                    val temp = input[j]//-->  O(1)
                    input[j] = input[j+1]//-->  O(1)
                    input[j+1] = temp//-->  O(1)
                }
            }
        }
        return input//-->  O(1)
    }

    fun  sortDescending(input: Array<Int>) : Array<Int> {
        val len = input.size
        for(i in 0..len-1) {
            for(j in 0 until len-i-1) {
                if(input[j] < input[j+1]) {
                    val temp = input[j]
                    input[j] = input[j+1]
                    input[j+1] = temp
                }
            }
        }
        return input
    }
}