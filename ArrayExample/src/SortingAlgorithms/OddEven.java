package SortingAlgorithms;

import java.util.Arrays;

public class OddEven {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(sortOddFirst(array)));
        System.out.println(Arrays.toString(sortEvenFirst(array)));

    }

    public static int[] sortOddFirst(int[] input) {
        int[] result = new int[input.length];
        int j =0 ;
        for (int k : input) {
            if (k % 2 != 0) {
                result[j++] = k;
            }
        }
        for (int k : input) {
            if (k % 2 == 0) {
                result[j++] = k;
            }
        }
        return result;
    }

    public static int[] sortEvenFirst(int[] input) {
        int[] result = new int[input.length];
        int j =0 ;
        for (int k : input) {
            if (k % 2 == 0) {
                result[j++] = k;
            }
        }
        for (int k : input) {
            if (k % 2 != 0) {
                result[j++] = k;
            }
        }
        return result;
    }
}
