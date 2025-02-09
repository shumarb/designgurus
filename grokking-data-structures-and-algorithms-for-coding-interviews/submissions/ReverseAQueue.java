// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/problem-1-reverse-a-queue-easy

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class ReverseAQueue {

    public Queue<Integer> reverseQueue(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        boolean isTest = true;

        if (isTest) {
            System.out.println("before populate stack | q: " + q + ", stack: " + stack);
        }
        while (!q.isEmpty()) {
            stack.push(q.poll());
        }
        if (isTest) {
            System.out.println("after populate stack | q: " + q + ", stack: " + stack);
        }

        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }
        if (isTest) {
            System.out.println("reversed queue | q: " + q + ", stack: " + stack);
        }
        return q;
    }
}
