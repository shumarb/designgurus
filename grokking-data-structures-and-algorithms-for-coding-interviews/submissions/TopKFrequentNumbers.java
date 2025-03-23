// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/top-k-frequent-numbers-medium

import java.util.*;

class TopKFrequentNumbers {
    public List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> topNumbers = new ArrayList<>(k);
        int[] numberFrequency = new int[200001];

        for (int number: nums) {
            numberFrequency[number + 10000]++;
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < numberFrequency.length; i++) {
            if (numberFrequency[i] > 0) {
                list.add(new int[] {i - 10000, numberFrequency[i]});
            }
        }
        list.sort((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < k; i++) {
            topNumbers.add(list.get(i)[0]);
        }
        return topNumbers;
    }
}
