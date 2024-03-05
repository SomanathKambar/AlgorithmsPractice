package LeetCode;

public class Fibonacci {
    /**
     *  0 1 1 2 3 5 8 13 21 34 55
     */

    public static void main(String[] args) {
        printFib(15);
    }

    public static void printFib(int len) {
        int n1 = 0, n2 = 1;
        System.out.print(n1 + "," + n2 + ",");
        for(int i = 2 ; i< len; i++) {
            int n3 = n1 + n2;
            n1=n2;
            n2 = n3;
            System.out.print(n2 + ",");
        }
    }
}
