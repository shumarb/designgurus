// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/6-perfect-square

public class PerfectSquare {
    public static boolean isPerfectSquare(int num) {
        return isPerfectSquare(num, 1);
    }

    private static boolean isPerfectSquare(int num, int i) {
        if (i * i > num) {
            return false;
        }

        if (i * i == num) {
            return true;
        }

        return isPerfectSquare(num, i + 1);
    }
}


