// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/problem-2-reverse-a-string-easy

import java.util.Stack;

public class ReverseAString {
    public String reverseString(String s) {
        Stack<Character> stack = new Stack();
        StringBuilder reverseString = new StringBuilder();
        for (char charS: s.toCharArray()) {
            stack.push(charS);
        }

        while (!stack.isEmpty()) {
            reverseString.append(stack.pop());
        }

        return reverseString.toString();
    }
}
