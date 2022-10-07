package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     *
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     */
    public static void main(String[] args) {
        int[] input = {2,7,11,15};
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(twoSumOptimum(input, 9)));
        System.out.println(Utils.getTimeDiff(start) + "ms");
        start = System.currentTimeMillis();
        System.out.println(Arrays.toString(twoSumBruteForce(input, 9)));
        System.out.println(Utils.getTimeDiff(start) + "ms");
    }

    public static int[] twoSumBruteForce(int[] input, int target) {
        int[] res = new int[2];
        for(int i =0 ; i<input.length; i++) {
            for(int j = i+1;  j < input.length ; j++) {
                if(input[i] + input[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    public static int[] twoSumOptimum(int[] input, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i= 0 ; i<input.length ; i++) {
            int diff = target - input[i];
            if(map.containsKey(diff)) {
                res[0] = i;
                res[1] = map.get(diff);
                return res;
            } else {
                map.put(input[i], i);
            }
        }
        return res;
    }
}
