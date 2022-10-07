package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {
    /**
     * Given a string s, return the longest palindromic substring in s.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * Example 2:
     * <p>
     * Input: s = "cbbd"
     * Output: "bb"
     * <p>
     * <p>
     * Constraints:
     * <p>
     * 1 <= s.length <= 1000
     * s consist of only digits and English letters.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input1 = "babad";
        String input2 = "cbbd";
        String input3 = "ac";
        String input4 = "aaaa";
        String input5 = " ";
        String input6 = "dddabcdcbaklm ";
        String input7 = "aacabdkacaa";
        String input8 = "abb";
        String input9 = "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel";
                        //0123456
        String input10 = "jrjnbctoqgzimtoklkxcknwmhiztomaofwwzjnhrijwkgmwwuazcowskjhitejnvtblqyepxispasrgvgzqlvrmvhxusiqqzzibcyhpnruhrgbzsmlsuacwptmzxuewnjzmwxbdzqyvsjzxiecsnkdibudtvthzlizralpaowsbakzconeuwwpsqynaxqmgngzpovauxsqgypinywwtmekzhhlzaeatbzryreuttgwfqmmpeywtvpssznkwhzuqewuqtfuflttjcxrhwexvtxjihunpywerkktbvlsyomkxuwrqqmbmzjbfytdddnkasmdyukawrzrnhdmaefzltddipcrhuchvdcoegamlfifzistnplqabtazunlelslicrkuuhosoyduhootlwsbtxautewkvnvlbtixkmxhngidxecehslqjpcdrtlqswmyghmwlttjecvbueswsixoxmymcepbmuwtzanmvujmalyghzkvtoxynyusbpzpolaplsgrunpfgdbbtvtkahqmmlbxzcfznvhxsiytlsxmmtqiudyjlnbkzvtbqdsknsrknsykqzucevgmmcoanilsyyklpbxqosoquolvytefhvozwtwcrmbnyijbammlzrgalrymyfpysbqpjwzirsfknnyseiujadovngogvptphuyzkrwgjqwdhtvgxnmxuheofplizpxijfytfabx";
        long start = System.currentTimeMillis();
    //    System.out.println("ans =" + solution.longestPalindrome(input10));
      //  System.out.println(System.currentTimeMillis()- start);
        start = System.currentTimeMillis();
        System.out.println("ans =" + solution.longestPalindromeOptim(input10));
        String palindromeString = "absdefghijkjihgfedsba";
    //    System.out.println(solution.getPalindromicSubStringByMatrix(palindromeString));
     //   System.out.println(System.currentTimeMillis() - start);
    }

    static class Solution {
        private static final int MIN_LENGTH_FOR_PALINDROME_CHECK = 2;

        public String longestPalindrome(String s) {
            int strLen = s.length();
            if (strLen < MIN_LENGTH_FOR_PALINDROME_CHECK) {
                return s;
            }
            String result = s.substring(0, 1);
            int uplimit = strLen;
            for (int i = 0; i < uplimit; i++) {
                for (int j = strLen; j > i; j--) {
                    String subStr = s.substring(i, j);
                    int subLen = subStr.length();
                   // System.out.println(subStr);
                    if (isPalindrome(subStr)) {
                        if (result.length() < subLen) result = subStr;
                    }
                }
            }

            return result;
        }

        private boolean isPalindrome(String in) {
            StringBuilder builder = new StringBuilder();
            for (int i = in.length() - 1; i >= 0; i--) {
                builder.append(in.charAt(i));
            }
            return builder.toString().equals(in);
        }

        int resultStart;
        int resultLength;

        public String longestPalindromeOptim(String s) {
            int strLength = s.length();
            System.out.println(s);
            if (strLength < 2) {
                return s;
            }
            for (int start = 0; start < strLength ; start++) {
                expandRange(s, start, start);
                //expandRange(s, start, start + 1);
            }
         //   System.out.println("resultStart ="+ resultStart + " end =" + (resultStart + resultLength));
            return s.substring(resultStart, resultStart + resultLength);
        }

        private void expandRange(String str, int begin, int end) {
            System.out.println("expandRangeStart  begin =" + begin + " end = " + end);
            while (begin >= 0 && end < str.length() &&
                    str.charAt(begin) == str.charAt(end)) {
            //    System.out.print(begin + ":" +  end + " ");
                System.out.println("begin = " + str.charAt(begin)  + " : " + begin + "  :: end ="  +  str.charAt(end) + ": " + end);

                begin--;
                end++;
                //    if(begin < 0) System.out.println(str.charAt(begin+1));
               // System.out.println("begin index ="+ begin + " end index = " + end);
            }
            System.out.println("break while begin = " + begin + " end=" + end + " resultLength = " + (end - begin - 1));
           // if(begin  > 0 && end < str.length())
       //     System.out.println("begin = " + str.charAt(begin)  + " : " + begin + "  :: end ="  +  str.charAt(end) + ": " + end);
            if (resultLength < end - begin - 1) {
                resultStart = begin + 1;
                resultLength = end - begin - 1;
                System.out.println(Utils.ANSI_YELLOW + "resultStart " + resultStart + ":" +  resultLength + " " + " result = " + str.substring(resultStart, resultStart + resultLength) + Utils.ANSI_RESET);
            }
        }

        //if a string 's' is palindrome it's palindromic substrings  will lei in a block where i + j = s.length();
        public List<String> getPalindromicSubStringByMatrix(String palindromeString) {
            List<String>  palindromicSubstrings = new ArrayList<>();
            int k = 0 ;
            for(int i =0 ; i< palindromeString.length() ; i++) {
                if(i == k && !palindromicSubstrings.contains(palindromeString.substring(i, k+1))) palindromicSubstrings.add(palindromeString.substring(i,k +1));
                for (int j = i +2; j < palindromeString.length(); j++) {
                    if(i + j == palindromeString.length()) {
                        palindromicSubstrings.add(palindromeString.substring(i,j));
                    }
                }
                k++;
            }
            return palindromicSubstrings;
        }
    }
}