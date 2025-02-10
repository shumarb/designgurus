// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/problem-5-zigzag-iterator-medium

import java.util.*;

class ZigzagIterator {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public Solution(List<Integer> v1, List<Integer> v2) {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        populate(v1, queue1);
        populate(v2, queue2);
    }

    private void populate(List<Integer> v1, Queue<Integer> queue) {
        for (Integer number: v1) {
            queue.offer(number);
        }
    }

    public int next() {
        if (!queue1.isEmpty()) {
            return queue1.poll();
        }
        if (!queue2.isEmpty()) {
            return queue2.poll();
        }
        return -1;
    }

    public boolean hasNext() {
        return (!queue1.isEmpty() || !queue2.isEmpty());
    }
}
