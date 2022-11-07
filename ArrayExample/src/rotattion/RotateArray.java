package rotattion;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int first = arr[0];
        int last = arr[arr.length -1];
        leftRotate(arr, first);
        System.out.println(Arrays.toString(arr));
        rightRotate(arr, first);
        System.out.println(Arrays.toString(arr));
    }

    private static void leftRotate(int[] arr, int item) {
        int size = arr.length;
        for(int i =0 ;i <size -1 ; i++) {
            arr[i] = arr[i + 1] ;
        }
        arr[size -1] = item;
    }

    private static void rightRotate(int[] arr, int item) {
        int size = arr.length;
        for(int i = size -1 ;i >0 ; i--) {
            arr[i] = arr[i -1];
        }
        arr[0] = item;
    }
}
