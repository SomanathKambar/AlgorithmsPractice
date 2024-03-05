package SortingAlgorithms

fun Array<Int>.print() {
    print("[")
    for(i in indices) {
        print(this[i])
        if(i < size-1) {
            print(",")
        }
    }
    print("]")
    println()
}
fun main() {
    val input = arrayOf(3, 6, 2, 7, 1, 4,5)
    val insertionSort = InsertionSort()
    insertionSort.sortAscending(input).print()
    insertionSort.sortDescending(input).print()

}
class InsertionSort {

    /**
     * step1: Take first element as sorted and loop through input from i = 1 until size-1
     * step2: Assign input[i] value to temp
     * step3: take a new variable j to loop through remaining array and assign i value to it
     * step4: loop through input if current element is > Previous element
     *          if yes current value with previous i.e. input[j] = input[j-1] and decrement j
     * step5: Assign tep value to current value input[j]
     */
    fun sortAscending(input:Array<Int>) : Array<Int> {
        for(i in 1 until input.size) {
            val temp = input[i]
            var j = i
            while(j>0 && input[j-1] > temp) {
//                println("swapping ${input[j]} with ${input[j-1]}, j = $j")
                input[j] = input[j-1]
                j--
            }
            input[j] = temp
        }
        return input
    }

    fun sortDescending(input:Array<Int>) : Array<Int> {
        for(i in 1 until input.size) {
            val temp = input[i]
            var j = i
            while(j>0 && input[j-1] < temp) {
                input[j] = input[j-1]
                j--
            }
            input[j] = temp
        }
        return input
    }
}