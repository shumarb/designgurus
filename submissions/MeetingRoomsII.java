// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/meeting-rooms-ii-medium

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsTwo {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        boolean isTest = false;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        if (isTest) {
            System.out.println("intervals (sorted by ascending start time):");
            for (int[] row: intervals) {
                System.out.println(Arrays.toString(row));
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (!minHeap.isEmpty() && intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }
        if (isTest) {
            System.out.println("minHeap: " + minHeap);
        }

        return minHeap.size();
    }
}
