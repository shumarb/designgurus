// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/6-perfect-square

public class PerfectSquare {
    public static boolean isPerfectSquare(int num) {
        return isPerfectSquare(num, 0, num);
    }

    private static boolean isPerfectSquare(int num, int low, int high) {
        if (low > high) {
            return false;
        }

        int mid = low + (high - low) / 2;
        long product = mid * mid;

        if (product == num) {
            return true;
        } else if (product < num) {
            return isPerfectSquare(num, mid + 1, high);
        } else {
            return isPerfectSquare(num, low, mid - 1);
        }
    }
}