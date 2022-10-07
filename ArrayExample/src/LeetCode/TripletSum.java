package LeetCode;

import java.util.*;

public class TripletSum {
    /*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     Notice that the solution set must not contain duplicate triplets.
    Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
    * */
    /* Algorithm brute force approach
            step1:  Traverse through teh array using 3 for loops and  find matching triplets
                    time complexity: O(n^3)
            Optimized Solution : Two pointer approach
            Step 1: Sort the Array in Ascending  order
            step 2: Traverse through the array for array.length - 2 , since we are using two pointers
            step 3: If i > 0 && element at position  i & i-1  are same skip/ continue next iteration
            step 4: Take two pointer j = i +1 & k = array.length -1;
            step 5: loop through the array while j < K and find the  sum , if sum = target then save the triplet
            step 6: if sum is > target increment  j, i.e. continue in front order else decrement k i.e. continue traverse
                    from end
    */


    public static void main(String[] args) {
        int[] sampleInput = {-1,0,1,2,-1,-4};
        int[] sampleInput0 = {0,0,0,0,0,0};
        int[] sampleInput1 = {0,1,1,};
        //[-1,0,1,2,-1,-4]

       // System.out.println(triplets(sampleInput));
       // System.out.println(distinctTriplet(sampleInput, 1));
        System.out.println(tripletBruteForce(sampleInput, 0));

    }

    public static  List<List<Integer>> tripletBruteForce(int[] input, int target) {
        int len = input.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(input);
        for(int i=0; i<len ; i++) {
            for(int j=i+1; j<len; j++) {
                for(int k = j+1; k<len; k++) {
                    int sum = input[i] + input[j] + input[k];
                    if(sum == target) {
                        List<Integer> triplet = List.of(input[i], input[j], input[k]);
                        if(!result.contains(triplet))
                        result.add(triplet);
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> distinctTriplet(int[] input, int target) {
            //Sort Array
            Arrays.sort(input);
            List<List<Integer>> result = new ArrayList();
            int length = input.length;
            for(int i =0 ; i<length -2; i++) {
                //Skip to the next iteration if element at i & i-1 are same
                   if(i > 0 && input[i] == input[i -1]) continue;
                int j = i +1, k = length -1;
                while(j<k) {
                    int sum = input[i] + input[j] + input[k];
                    if(sum == target) {
                        result.add(List.of(input[i], input[j], input[k]));
                    }
                    if(sum < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            return result;
    }

    public static List<List<Integer>> triplets(int[] input) {
        List<List<Integer>> triplets = new ArrayList<>();

        return triplets;
    }
}
