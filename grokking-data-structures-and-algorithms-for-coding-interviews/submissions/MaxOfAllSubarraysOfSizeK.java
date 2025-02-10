// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/problem-6-max-of-all-subarrays-of-size-k

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxOfAllSubarraysOfSizeK {
    public List<Integer> printMax(int[] arr, int k) {
        List<Integer> result = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<>();
        boolean isTest = false;
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr) + ", k: " + k);
        }

        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        if (isTest) {
            System.out.println("queue: " + queue);
        }
        result.add(getMaximum(queue));

        for (int i = k; i < arr.length; i++) {
            queue.poll();
            if (isTest) {
                System.out.println("queue after removal: " + queue);
            }
            queue.offer(arr[i]);
            if (isTest) {
                System.out.println("queue after adding new element: " + queue);
            }
            result.add(getMaximum(queue));
            if (isTest) {
                System.out.println("result so far: " + Arrays.toString(arr));
            }
        }

        if (isTest) {
            System.out.println("final result: " + Arrays.toString(arr));
        }
        return result;
    }

    private int getMaximum(Queue<Integer> queue) {
        Integer[] array = queue.toArray(new Integer[0]);
        int maximum = array[0];
        for (int number: array) {
            maximum = Math.max(maximum, number);
        }
        return maximum;
    }
}
