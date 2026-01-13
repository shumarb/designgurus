// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/17-good-number

import java.util.Arrays;
import java.util.List;

public class Solution {
    private static boolean isGoodNumber(int index, String arg) {
        if (index == arg.length()) {
            return true;
        }

        if (index % 2 == 0) {
            int digit = arg.charAt(index) - '0';
            if (digit % 2 == 1) {
                return false;
            }
        } else {
            int digit = arg.charAt(index) - '0';
            if (!isPrime(digit)) {
                return false;
            }
        }

        return isGoodNumber(index + 1, arg);
    }

    private static boolean isPrime(int n) {
        return n == 2 || n == 3 || n == 5 || n == 7;
    }

    public static boolean isGoodNumber(String arg) {
        return isGoodNumber(0, arg);
    }
}
