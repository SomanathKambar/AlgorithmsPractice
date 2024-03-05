package array;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
       System.out.println(Arrays.toString(removeDuplicates(new int[]{1, 1, 2, 2, 3, 4, 5})));
    }

    public static int[] removeDuplicates(int[] array) {
        int n = array.length;
        int[] uniqueArray = new int[n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < n; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueArray[index++] = array[i];
            }
        }

        return Arrays.copyOf(uniqueArray, index);
    }
}
