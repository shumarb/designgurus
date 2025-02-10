// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/problem-3-generate-binary-numbers-from-1-to-n

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbersFromIToN {
    public static String[] generateBinaryNumbers(int n) {
        String[] res = new String[n];
        boolean isTest = true;

        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 0; i < n; i++) {
            res[i] = queue.poll();
            queue.offer(res[i] + "0");
            queue.offer(res[i] + "1");
            if (isTest) {
                System.out.println("res so far: " + Arrays.toString(res) + " | queue so far: " + queue);
            }
        }
        if (isTest) {
            System.out.println("final res: " + Arrays.toString(res) + " | final queue: " + queue);
        }

        return res;
    }
}
