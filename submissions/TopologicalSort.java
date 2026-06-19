// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/topological-sort-medium

import java.util.*;

class TopologicalSort {
    public List<Integer> sort(int vertices, int[][] edges) {
        List<Integer>[] graph = new ArrayList[vertices];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[vertices];
        boolean isTest = false;
        int[] inDegree = new int[vertices];
        int level = -1;

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            inDegree[edge[1]]++;
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }
        if (isTest) {
            System.out.println("inDegree: " + Arrays.toString(inDegree) + "\ngraph:");
            for (int i = 0; i < graph.length; i++) {
                System.out.println(" * " + i + " -> " + graph[i]);
            }
            System.out.println("----------------------------------------------------\ndfs: ");
        }

        while (!stack.isEmpty()) {
            int size = stack.size();
            ++level;

            if (isTest) {
                System.out.println(" * level " + level + ": " + stack);
            }
            for (int i = 0; i < size; i++) {
                int current = stack.pop();

                // 1. Cycle detected.
                if (isVisited[current]) {
                    return new ArrayList<>();
                }

                isVisited[current] = true;
                result.add(current);
                for (int neighbour: graph[current]) {
                    // 2. Cycle detected.
                    if (isVisited[neighbour]) {
                        return new ArrayList<>();
                    }
                    stack.push(neighbour);
                }
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------------\nisVisited: " + Arrays.toString(isVisited) + "\nresult: " + result);
        }

        return result;
    }
}
