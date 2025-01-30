// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/problem-4-next-greater-element-easy

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class NextGreaterElement {

    public List<Integer> nextLargerElement(List<Integer> arr) {
        int n = arr.size();
        Stack<Integer> stack = new Stack<>();
        Integer[] res = new Integer[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr.get(i)) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }

            stack.push(arr.get(i));
        }

        return Arrays.asList(res);
    }
}
