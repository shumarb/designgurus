// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/1-basic-sum

public class Solution {
    public static int calculateSum(int N) {
        return N == 1 ? 1 : N + calculateSum(N - 1);
    }
}