package array

import java.util.Arrays


/**
 * Subarray with Given Sum
 *
 * Given a 1-based indexing array arr[] of non-negative integers and an integer sum. You mainly need to return the left and right indexes(1-based indexing) of that subarray. In case of multiple subarrays, return the subarray indexes which come first on moving from left to right. If no such subarray exists return an array consisting of element -1.
 *
 * Examples:
 *
 * Input: arr[] = [15, 2, 4, 8, 9, 5, 10, 23], target = 23
 * Output: [2, 5]
 * Explanation: Sum of subarray arr[2...5] is 2 + 4 + 8 + 9 = 23.
 *
 * Input: arr[] = [1, 10, 4, 0, 3, 5], target = 7
 * Output: [3, 5]
 * Explanation: Sum of subarray arr[3...5] is 4 + 0 + 3 = 7.
 *
 * Input: arr[] = [1, 4], target = 0
 * Output: [-1]
 * Explanation: There is no subarray with 0 sum.
 */
class SubArraySum {
    fun subarraySum(nums: IntArray, target: Int): IntArray {
        var  sum = 0
        for(i in 0 until  nums.size) {
            sum = nums[i]
            for(j in i+1 until  nums.size) {
                sum += nums[j]
                if(sum == target) {
                    return intArrayOf( i +1, j +1)
                }
            }
        }
        return intArrayOf( -1 )
    }
}

fun main() {
    val subarraySum = SubArraySum()
    val input1 = intArrayOf(15, 2, 4, 8, 9, 5, 10, 23)
    val target = 23
   val result =  subarraySum.subarraySum(input1, target)
    print(Arrays.toString(result))
}