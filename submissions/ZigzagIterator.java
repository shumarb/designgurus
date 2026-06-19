// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/problem-5-zigzag-iterator-medium

import java.util.*;

class ZigzagIterator {
    private Queue<Integer> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        populate(queue, v1, v2);
    }

    private void populate(Queue<Integer> queue, List<Integer> v1, List<Integer> v2) {
        int current = 1;
        int i = 0;
        int j = 0;
        boolean isTest = false;

        if (isTest) {
            System.out.println("v1: " + v1 + ", v2: " + v2);
        }

        while (i < v1.size() || j < v2.size()) {
            if (current == 1) {
                if (i < v1.size()) {
                    queue.offer(v1.get(i++));
                }
                current = 2;
            } else {
                if (j < v2.size()) {
                    queue.offer(v2.get(j++));
                }
                current = 1;
            }
            if (isTest) {
                System.out.println("queue so far: " + queue);
            }
        }

        if (isTest) {
            System.out.println("updated queue: " + queue);
        }
    }

    public int next() {
        return queue.isEmpty() ? -1 : queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}