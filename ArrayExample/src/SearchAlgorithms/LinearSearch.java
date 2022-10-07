package SearchAlgorithms;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class LinearSearch {
    //Linear Search traverse through each element for match
    // Worst case Complexity will be O(n) and Best Will be O(1)

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(hasElementUSingStream(array, 3));
        System.out.println(hasElement(array, 9));
    }

    private static boolean hasElement(int[] arrays, int key) {
        for(int i=0; i< arrays.length; i++) {
            if(arrays[i] == key) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasElementUSingStream(int[] arrays, int key) {
      return   Arrays.stream(arrays).filter(num -> num == key).findFirst().isPresent();
    }

    private static boolean hasElementUSingStream2(int[] arrays, int key) {
        IntPredicate hasElement = num -> num == key;
        return   Arrays.stream(arrays).filter(hasElement).findFirst().isPresent();
    }
}
