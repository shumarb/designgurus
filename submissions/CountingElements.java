// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/problem-1-counting-elements-easy

import java.util.HashSet;

public class CountingElements {
    public int countElements(int[] arr) {
        int count = 0;
        boolean[] numberFrequency = new boolean[1001];
        for (int number: arr) {
            numberFrequency[number] = true;
        }
        for (int number: arr) {
            if (numberFrequency[number + 1]) {
                count++;
            }
        }
        return count;
    }
}
