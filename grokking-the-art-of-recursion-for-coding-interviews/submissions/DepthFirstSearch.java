// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/14-depth-first-search

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class DepthFirstSearch {
    private Map<Integer, List<Integer>> graph;
    private List<Integer> depthFirstSearch;
    private Set<Integer> visited;

    private void dfs(int source) {
        visited.add(source);
        depthFirstSearch.add(source);

        for (int neighbour: graph.get(source)) {
            if (!visited.contains(neighbour)) {
                dfs(neighbour);
            }
        }
    }

    public List<Integer> DFS(List<List<Integer>> args, int n, int first) {
        boolean isTest = false;
        graph = new HashMap<>();
        depthFirstSearch = new ArrayList<>();
        int start = Integer.MAX_VALUE;
        visited = new HashSet<>();

        for (List<Integer> e: args) {
            int source = e.get(0);
            int target = e.get(1);
            start = Math.min(source, Math.min(start, target));
            graph.putIfAbsent(source, new ArrayList<>());
            graph.putIfAbsent(target, new ArrayList<>());
            graph.get(source).add(target);
            graph.get(target).add(source);
        }

        dfs(start);
        if (isTest) {
            System.out.println("args:");
            for (List<Integer> e: args) {
                System.out.println(" * " + e);
            }
            System.out.println("-----------------------------------\ngraph:");
            for (Map.Entry<Integer, List<Integer>> e: graph.entrySet()) {
                System.out.println(" * " + e.getKey() + " -> " + e.getValue());
            }
            System.out.println("-----------------------------------\nstart: " + start + "\ndepthFirstSearch: " + depthFirstSearch);
        }

        return depthFirstSearch;
    }
}
