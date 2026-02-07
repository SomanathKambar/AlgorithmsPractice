package array

/**
 *
 * Maximum occurring element in a subarray range (Mode queries)
 * Given an array arr[] of N integers, and an array Q[] of M pairs,
 * where a pair represents a query of the form {L, R},
 * the task is to find the maximum occurring element in the range [L, R] and its frequency for each query.
 * If there are multiple elements with maximum frequency,
 * then print the maximum element among them.
 *
 * Examples:
 *
 * Input: arr[] = {5, 7, 5, 5, 2, 7, 3, 2, 5, 2}, Q[] = {{0, 9}, {3, 6}, {4, 8}, {1, 5}}
 * Output: 5 Occurs 4 times
 *               3 Occurs 1 times
 *               2 Occurs 2 times
 *               7 Occurs 2 times
 * Explanation:
 * The queries are performed as:
 *
 *
 *
 * Query(0, 9): The subarray over the range is {5, 7, 5, 5, 2, 7, 3, 2, 5, 2}. Elements 5, 7, 2, and 3 occur 4, 2, 3 and 1 times respectively. Therefore, print 5.
 * Query(3, 6): The subarray over the range is {5, 2, 7, 3}. Every element occurs once. So print element 7.
 * Query(4, 8): The subarray over the range is {2, 7, 3, 2, 5}. Element 2 occurs twice and the remaining all occurs once. Therefore, print 2.
 * Query(1, 5): The subarray over the range is {7, 5, 5, 2, 7, 3}. Elements 7 and 5 occur twice and the remaining elements occur once. Therefore print 7.
 */
class MaxOccurringElement {

    fun maxOccur(nums: IntArray, start:Int, end:Int): Int {
        val length = nums.size
        if(length == 0 || end > length || start > length || start < 0) return 0
        if(length == 1) return nums[0]
        val map = HashMap<Int, Int>()
        for (i in start until end) {
            if(map.containsKey(nums[i])) {
                val current = map.get(nums[i]) !!
                map.put(nums[i], current +1)
            } else {
                map.put(nums[i], 1)
            }
        }
        var max = 0

        for(entry in map.entries) {
            if(entry.value> max) {
                max= entry.key
            } else if(entry.value == max) {
                max = if(entry.key > max) entry.key else max
            }
        }

        return max

    }
}

fun main() {
    val maxOccurringElement = MaxOccurringElement()

    val arr = intArrayOf(5, 7, 5, 5, 2, 7, 3, 2, 5, 2)
    val res = maxOccurringElement.maxOccur(arr, 3, 6)
    println(res)

}