package LeetCode;

import java.util.*;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
      int[]  nums1 = {1,3}, nums2 = {2, 4}; //1,1,1,2,
        System.out.println(findMedianSortedArrays(nums2, nums1));
    }
     public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
         ArrayList<Integer> result = new ArrayList<>();
         int len1= 0;
         int len2 = 0;
         while(len1 < nums1.length  || len2 < nums2.length ) {
             if(len1 < nums1.length) {
                 result.add(nums1[len1]);
                 len1++;
             }
             if(len2 < nums2.length) {
                 result.add(nums2[len2]);
                 len2++;
             }
         }
         int size = result.size();
         Collections.sort(result);
         if(size % 2 == 0) {
             size = size / 2;
             return (result.get(size) + result.get(size -1)) / 2.0;
         }
         return result.get(size / 2);
     }
}
