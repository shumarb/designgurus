// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/minimum-cost-to-connect-sticksmedium

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        // 1. Edge case: only 1 stick, so no sticks to combine, hence return 0
        if (sticks.length == 1) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick: sticks) {
            minHeap.offer(stick);
        }

        int totalCost = 0;
        while (minHeap.size() > 1) {
            // 2. Retrieve 2 shortest sticks
            int stick1 = minHeap.poll();
            int stick2 = minHeap.poll();

            // 3. Compute cost of 2 shortest sticks
            int cost = stick1 + stick2;

            // 4. Add cost to totalCost incurred so far
            totalCost += cost;

            // 5. Add cost to minHeap
            minHeap.offer(cost);
        }

        return totalCost;
    }
}
