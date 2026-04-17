// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-3-medium

import java.util.*;

class IslandMatrixTraversalProblemChallengeThree {
    private boolean[][] isVisited;
    private boolean isCycleFound;
    private boolean isTest;
    private char[][] matrix;
    private int m;
    private int n;

    public boolean hasCycle(char[][] matrix) {
        isTest = false;
        m = matrix.length;
        n = matrix[0].length;
        isVisited = new boolean[m][n];
        this.matrix = matrix;

        if (isTest) {
            print("matrix:");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisited[i][j]) {
                    continue;
                }

                isCycleFound = false;
                dfs(matrix[i][j], i, j, -1, -1);
                if (isCycleFound) {
                    if (isTest) {
                        System.out.println("cycle found @ path starting with [" + i + ", " + j + "]:");
                        System.out.println("---------------------------");
                    }
                    return true;
                }
            }
        }

        return false;
    }

    private void dfs(char letter, int row, int column, int parentRow, int parentColumn) {
        if (isCycleFound || row < 0 || row >= m || column < 0 || column >= n || matrix[row][column] != letter) {
            return;
        }

        // 1. Cycle found when current cell is a previously-visited cell in current path.
        if (isVisited[row][column]) {
            isCycleFound = true;
            return;
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        isVisited[row][column] = true;

        for (int[] direction: directions) {
            int adjacentColumn = column + direction[1];
            int adjacentRow = row + direction[0];

            // 2. Don't visit cell you just came from.
            if (adjacentColumn == parentColumn && adjacentRow == parentRow) {
                continue;
            }

            dfs(letter, adjacentRow, adjacentColumn, row, column);
        }

    }

    private void print(String s) {
        System.out.println(s);
        for (char[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
