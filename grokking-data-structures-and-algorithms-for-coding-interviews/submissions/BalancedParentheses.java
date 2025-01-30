// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/problem-1-balanced-parentheses-easy

import java.util.Stack;

public class BalancedParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<> ();
        boolean isTest = false;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
                if (isTest) {
                    System.out.println("added: " + currentChar + " | stack: " + stack);
                }
            } else {
                if (isTest) {
                    System.out.println("check with top element: " + currentChar);
                }
                if (currentChar == ')' && stack.pop() != '(') {
                    return false;
                } else if (currentChar == '}' && stack.pop() != '{') {
                    return false;
                } else if (currentChar == ']' && stack.pop() != '[') {
                    return false;
                }
            }
        }
        if (isTest) {
            System.out.println("s: " + s + "\nstack: " + stack);
        }
        return stack.isEmpty();
    }
}
