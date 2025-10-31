// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/5-check-prime

public class CheckPrime {
    private static boolean result;

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        result = true;
        helper(number, 2, (int) Math.sqrt(number));

        return result;
    }

    private static void helper(int number, int i, int limit) {
        if (i > limit) {
            return;
        }

        if (number % i == 0) {
            result = false;
            return;
        }

        helper(number, i + 1, limit);
    }
}
