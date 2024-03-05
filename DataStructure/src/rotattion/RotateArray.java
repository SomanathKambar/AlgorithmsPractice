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
        int[][] arr2 = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
//        rotateMatrix(3,arr2);
        rotateMatrix(arr2);
        System.out.println(Arrays.deepToString(arr2));
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

    public static boolean rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i=first; i<last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;

            }

        }
        return true;

    }
    static void rotateMatrix(int N, int mat[][])
    {
        // Consider all squares one by one
        for (int x = 0; x < N / 2; x++) {
            // Consider elements in group
            // of 4 in current square
            for (int y = x; y < N - x - 1; y++) {
                // Store current cell in
                // temp variable
                int temp = mat[x][y];

                // Move values from right to top
                mat[x][y] = mat[y][N - 1 - x];

                // Move values from bottom to right
                mat[y][N - 1 - x]
                        = mat[N - 1 - x][N - 1 - y];

                // Move values from left to bottom
                mat[N - 1 - x][N - 1 - y]
                        = mat[N - 1 - y][x];

                // Assign temp to left
                mat[N - 1 - y][x] = temp;
            }
        }
    }
}
