// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/3-greatest-common-divisor-gcd

public class GreatestCommonDivisor {
    public static int calculateGCD(int A, int B) {
        return B == 0 ? A : calculateGCD(B, A % B);
    }
}
