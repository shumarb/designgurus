// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/problem-3-decimal-to-binary-conversion-medium

import java.util.Stack;

public class DecimalToBinaryConversion {
    public static String decimalToBinary(int num) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> bits = new Stack<>();
        while (num != 0) {
            bits.push(num % 2);
            num /= 2;
        }
        while (!bits.isEmpty()) {
            sb.append(bits.pop());
        }
        return sb.toString();
    }
}