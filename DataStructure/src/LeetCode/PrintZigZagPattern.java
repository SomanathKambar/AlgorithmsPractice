package LeetCode;

public class PrintZigZagPattern {
    /**
     * Print the first row with 1 to N numbers.
     * Then from 2nd to (N-1)th row, print 2 * (N – index – 1) times blank spaces followed by the ending element which is index – 1.
     * Print the last row with 1 to N numbers.
     *
     */


    public static void main(String[] args) {
        printZigZag(11, 6);
      //  alphabetPattern(6);
}

    public static void printZigZag(int length, int height) {
        int[][] wave = new int[length][length];
        System.out.print(Utils.ANSI_YELLOW + " ");
        for(int i =0 ; i<length; i ++) {
            System.out.print(i);
        }
        System.out.println(Utils.ANSI_RESET);
        for(int i = 0 ; i<height; i++) {
            System.out.print(Utils.ANSI_YELLOW + i +  Utils.ANSI_RESET);
            System.out.print("*");
            for(int j = 0; j< length; j++) {
                if(j== 2* (height -1)) // j== 2* (height -1) -- condition to print start and end columns
                    System.out.print("*");
//                 if( j != i && j % height -1 != 0)
//                    System.out.print("*");
                else System.out.print("-");
            }
            System.out.println();
      //  System.out.println(Arrays.deepToString(wave));
    }
    }


    static void alphabetPattern(int N)
    {

        int index, side_index;

        // Declaring the values of Right,
        // Left and Diagonal values
        int Top = 1, Bottom = 1, Diagonal = N - 1;

        // Loop for printing the first row
        for (index = 0; index < N; index++)
            System.out.print(Top++ + " ");

        System.out.println();

        // Main Loop for the rows from (2 to n-1)
        for (index = 1; index < N - 1; index++)
        {

            // Spaces for the diagonals
            for (side_index = 0;
                 side_index < 2 * (N - index - 1);
                 side_index++)
                System.out.print(" ");

            // Printing the diagonal values
            System.out.print(Diagonal--);

            System.out.println();
        }

        // Loop for printing the last row
        for (index = 0; index < N; index++)
            System.out.print(Bottom++ + " ");
    }

}
