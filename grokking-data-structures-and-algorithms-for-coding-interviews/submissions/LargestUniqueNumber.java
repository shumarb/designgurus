// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/problem-2-largest-unique-number-easy

import java.util.HashMap;

public class LargestUniqueNumber {
    public int largestUniqueNumber(int[] A) {
        int[] numberFrequency = new int[1001];
        boolean isTest = false;

        for (int number: A) {
            numberFrequency[number]++;
        }
        if (isTest) {
            System.out.println("A: " + Arrays.toString(A) + "\nnumberFrequency: " + Arrays.toString(numberFrequency));
        }

        int maximumUniqueNumber = Integer.MIN_VALUE;
        for (int number: A) {
            if (numberFrequency[number] == 1) {
                maximumUniqueNumber = Math.max(maximumUniqueNumber, number);
            }
        }
        return maximumUniqueNumber == Integer.MIN_VALUE ? -1 : maximumUniqueNumber;
    }
}
