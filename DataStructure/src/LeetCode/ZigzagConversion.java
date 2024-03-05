package LeetCode;

public class ZigzagConversion {

    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * string convert(string s, int numRows);
     *
     *
     * Example 1:
     *
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     * Example 2:
     *
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     */


    // P           R   0        10   FOR 3 = 1 , FOR 4= 2, FOR 5 = 3, FOR 6 =  4
    // A         I I   1      9 11
    // Y       H   N   2     8  12
    // P     S     G   3    7   13
    // A   I           4  6              10    8,2       6,4     4,6      2
    // L               5                010 : 1,9,11 : 2,8,12 : 3,7,13 : 4,6 :  5

//    P     I    N   0     6       12
//    A   L S  I G   1   5 7    11 13
//    Y A   H R      2 4   8 10          //  6      4, 2, 4, 2    2, 4, 2     6
//    P     I        3     9             //0,6,12: 1,5,7,11,13 : 2,4,8,10, : 3,9
    public static void main(String[] args) {
                //012345678910111213   P
    String input="PAYPALISHIRING";

        //P   A     H     N    0   4    8     12
        //A P L  S  I  I  G    1 3 5  7 9  11 13      3, 7, 11              numRows + 1  numRows -1        numRows +
        //Y   I     R          2   6   10              4  , 4      diff=      4,4,4 :   2,2,2,2,2,2    :  4,4
        System.out.println(convert(input, 4));   // "PAHNAPLSIIGYIR" 0,4,8,12: 1,3,5,7,9,11,13 : 2,6,10
    }

    public  static String convert(String s, int numRows) {
        if(s.isEmpty() || s.length() <= numRows) return s;
        StringBuilder builder = new StringBuilder();
        int len = s.length();
        int count = 0 , row = s.length() / numRows ;
        int joint = numRows -2;
        int increment =0;
        while(count < row ) { //0,1,
            System.out.println("count = " + count);
            if(count % 2 == 0) increment = numRows + joint; else increment = numRows - joint; //4,2,
        for(int i = count ; i < len ; i+=increment) {        //0,4,8,12
                builder.append(s.charAt(i));                    // PINALSIGYAHRPI : 0,6,12, 2,5,7,9,
            System.out.println("char = " + s.charAt(i));        //P,A,H,N,
        }
        count++;
        }
        return builder.toString();
    }
}
