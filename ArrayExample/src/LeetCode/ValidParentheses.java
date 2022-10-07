package LeetCode;

import java.util.Stack;

public class ValidParentheses {
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     */

    public static void main(String[] args) {
        String sample = "{{[()]}}";
        String sample1 = "(){}}{";
        String sample2 = "{}";
        String sample3 = "(])";
        System.out.println(isValidParentheses(sample));
        System.out.println(isValidParentheses(sample1));
        System.out.println(isValidParentheses(sample3));
    }

    public static boolean isValidParentheses(String s) {
        Stack<Character> chars = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == '(' || ch =='{' || ch == '[') {
                chars.push(ch);
            } else if(chars.isEmpty()) {
                return false;
            } else if(chars.peek().equals(getOpen(ch))){
                chars.pop();
            } else {
                return false;
            }
        }
        return chars.isEmpty();
    }

    public static char getOpen(char c) {
        return switch (c) {
            case ')' -> '(';
            case '}' -> '{';
            case ']' -> '[';
            default -> c;
        };
    }
}
