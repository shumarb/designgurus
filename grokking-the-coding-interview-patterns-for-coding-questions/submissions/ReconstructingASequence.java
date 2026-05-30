// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-1-reconstructing-a-sequence-hard

import java.util.*;

class ReconstructingASequence {
    public boolean canConstruct(int[] originalSeq, int[][] sequences) {
        List<Integer> list = new ArrayList<>();
        List<Integer>[] graph;
        Queue<Integer> queue = new LinkedList<>();
        boolean isTest = false;
        int[] inDegree;
        int index = 0;
        int largest = 0;
        int level = 0;

        for (int e: originalSeq) {
            largest = Math.max(e, largest);
        }
        graph = new ArrayList[largest + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        inDegree = new int[largest + 1];

        for (int[] sequence: sequences) {
            for (int i = 0; i < sequence.length - 1; i++) {
                int destination = sequence[i + 1];
                int source = sequence[i];
                graph[source].add(destination);
                inDegree[destination]++;
            }
        }
        if (isTest) {
            System.out.println("inDegree: " + Arrays.toString(inDegree) + "\ngraph:");
            for (int i = 1; i <= largest; i++) {
                System.out.println(" * " + i + ": " + graph[i]);
            }
            System.out.println("---------------------------------------");
        }

        for (int i = 1; i <= largest; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            if (isTest) {
                System.out.println(" * level " + level + ": " + queue);
            }

            int size = queue.size();

            // 1. There exists more than 1 path that may lead to last vertex
            // so there may be more than 1 solution (if it exists).
            if (size > 1) {
                return false;
            }

            while (size-- > 0) {
                int source = queue.poll();
                list.add(source);
                for (int destination: graph[source]) {
                    if (--inDegree[destination] == 0) {
                        queue.offer(destination);
                    }
                }
            }

            level++;
        }
        if (isTest) {
            System.out.println("---------------------------------------\nlist: " + list);
        }

        if (list.size() != originalSeq.length) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != originalSeq[i]) {
                return false;
            }
        }

        return true;
    }
}
