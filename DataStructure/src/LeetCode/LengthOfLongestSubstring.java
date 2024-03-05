package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "pwwkew";
        String str1 = "bbbbb";
        String str2 = "abcabcbbbb ";
        String str3 = "dvdf";
//        System.out.println(lengthOfLongestSubstringOptim(str3));
//        System.out.println(lengthOfLongestSubstringOptim(str));
        System.out.println(lengthOfLongestSubstringOptim(str2));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        List<String> visited = new ArrayList<>();
        int length =0 ;
        int prev =0 ;
        String[] chars = s.split("");
        for(int i =0 ; i< chars.length ; i++) {
            if(visited.contains(chars[i])) {
//                if(i < chars.length -1) {
//                    length = 1 ;
//                }
                System.out.println("in if "+ chars[i]);
                System.out.println("length "+ length);
             //   visited.remove(chars[i]);
            } else {
                visited.add(chars[i]);
                System.out.println("in else "+ chars[i]);
                length++;
                System.out.println("length "+ length);
            }
            prev = Integer.max(prev, length);
        }
        return prev;
    }

    public static int lengthOfLongestSubstringOptim(String s) {
        int max  = 0, index = 0;
        Set<Character> visited = new HashSet<>();
        for(int j=0 ; j<s.length(); j++) {
            char ch = s.charAt(j);
            while(visited.contains(ch)) {
                char c = s.charAt(index++);
                System.out.println("removed = " + c);
                visited.remove(c);
                System.out.println("index = " + index);
            }
            visited.add(ch);
            System.out.println("j = " + j);
            System.out.println("max = " + max);
            max = Integer.max(max, j-index+1);
        }
        return max;
    }
}
