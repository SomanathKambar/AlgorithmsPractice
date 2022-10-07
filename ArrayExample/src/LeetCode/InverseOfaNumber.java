package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class InverseOfaNumber {

    /**
     * 1. You are given a number following certain constraints.
     * 2. The key constraint is if the number is 5 digits long, it'll contain all the digits from 1 to 5 without missing any and without repeating any. e.g. 23415 is a 5 digit long number containing all digits from 1 to 5 without missing and repeating any digit from 1 to 5.Take a look at few other valid numbers - 624135, 81456273 etc.Here are a few invalid numbers - 139, 7421357 etc.
     * 3. The inverse of a number is defined as the number created by interchanging the face value and index of digits of number.e.g. for 426135 (reading from right to left, 5 is in place 1, 3 is in place 2, 1 is in place 3, 6 is in place 4, 2 is in place 5 and 4 is in place 6), the inverse will be 416253 (reading from right to left, 3 is in place 1, 5 is in place 2,2 is in place 3, 6 is in place 4, 1 is in place 5 and 4 is in place 6) More examples - inverse of 2134 is 1243 and inverse of 24153 is 24153
     * 4. Take as input number "n", assume that the number will follow constraints.
     * 5. Print it's inverse.
     *      12345678   654321    654321
     * in = 28346751,  426135  , 416253
     *       87654321
     * out = 73425681, 416253
     */

    public static void main(String[] args) {
        int in =  28346751;
        System.out.println(getInverse(in));
    }

    public static int getInverse(int origin) {
        Map<Integer,Integer>  map = new HashMap<>();
        Map<Integer,Integer>  res = new HashMap<>();
        int temp = origin;
        int count =1 ;
        while (temp != 0) {
            //426135  -> 1-> 5, 2 -> 3,  3->1, 4->6, 5->2, 6->4
            //416253  -> 1-> 3, 2 -> 5,  3->2, 4->6, 5->1, 6->4
            map.put(count++ , temp % 10);
            temp = temp / 10;
        }

        System.out.println(map);
        for(Integer s: map.values()) {
            res.put(map.get(s), s);
        }

        System.out.println(res);
        int size = res.size();

        while(size > 0) {
            temp = temp * 10 +  res.get(size--);
        }
        return temp;
    }
}
