// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/3-greatest-common-divisor-gcd

public class GreatestCommonDivisor {
    public static int calculateGCD(int A, int B) {
        return helper(A, B, Math.min(A, B));
    }

    private static int helper(int A, int B, int denominator) {
        if (denominator == 1) {
            return 1;
        }

        if (A % denominator == 0 && B % denominator == 0) {
            return denominator;
        }

        return helper(A, B, denominator - 1);
    }
}
