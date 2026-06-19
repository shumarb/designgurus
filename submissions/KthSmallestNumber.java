// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/kth-smallest-number-hard

import java.util.*;

class KthSmallestNumber {
    public int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int number: nums) {
            maxHeap.offer(number);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}
