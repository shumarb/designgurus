// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-2-medium

import java.util.*;

class IslandMatrixTraversalProblemChallengeTwo {
    private int[][] matrix;
    private int m;
    private int n;

    public int findDistinctIslandsDFS(int[][] matrix) {
        Set<String> set = new HashSet<>();
        boolean isTest = false;
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;

        if (isTest) {
            System.out.println("matrix:");
            for (int[] row: matrix) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println("---------------------");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    // 1. Current cell is origin of island.
                    StringBuilder traversal = new StringBuilder('O');
                    dfs(traversal, i, j);

                    // 2. Traversal starts and ends at current cell.
                    traversal.append('O');

                    if (isTest) {
                        System.out.println("island @ [" + i + ", " + j + "]: " + traversal);
                    }

                    set.add(traversal.toString());
                }
            }
        }
        if (isTest) {
            System.out.println("---------------------\nset: " + set + "\nresult: " + set.size());
        }

        return set.size();
    }

    private void dfs(StringBuilder traversal, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] == 0) {
            return;
        }

        matrix[i][j] = 0;

        if (i - 1 >= 0 && matrix[i - 1][j] == 1) {
            traversal.append('U');
            dfs(traversal, i - 1, j);
        }

        if (i + 1 < m && matrix[i + 1][j] == 1) {
            traversal.append('D');
            dfs(traversal, i + 1, j);
        }

        if (j - 1 >= 0 && matrix[i][j - 1] == 1) {
            traversal.append('L');
            dfs(traversal, i, j - 1);
        }

        if (j + 1 < n && matrix[i][j + 1] == 1) {
            traversal.append('R');
            dfs(traversal, i, j + 1);
        }
    }
}
