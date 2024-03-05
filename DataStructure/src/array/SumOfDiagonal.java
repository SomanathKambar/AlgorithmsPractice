package array;

import java.util.Arrays;

public class SumOfDiagonal {

    public static void main(String[] args) {
       int[][] arr = new int[3][3];
       arr[0][0] = 1;
       arr[0][1] = 2;
       arr[0][2] = 3;
       arr[1][0] = 4;
       arr[1][1] = 5;
       arr[1][2] = 6;
       arr[2][0] = 7;
       arr[2][1] = 8;
       arr[2][2] = 9;
       System.out.println("sum = "+ sumDiagonalElements(arr));
    }
    public static int sumDiagonalElements(int[][] array) {
        int sizeOuter = array.length;
        int sum = 0;
       Arrays.sort(array);
        System.out.print("Diagonal = [");
        for(int i =0 ; i<sizeOuter; i++) {
            System.out.print(array[i][i] + ",");
            if(i == sizeOuter -1)
             System.out.print("]");
           sum += array[i][i];
        }
        return sum ;
    }
}
