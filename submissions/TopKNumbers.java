// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/top-k-numbers-easy

import java.util.*;

class TopKNumbers {
    public List<Integer> findKLargestNumbers(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        boolean isTest = false;

        for (int e: nums) {
            minHeap.offer(e);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        if (isTest) {
            System.out.println("minHeap: " + minHeap);
        }
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        return result;
    }
}
