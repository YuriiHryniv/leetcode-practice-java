package max_number_of_fish_in_grid;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int findMaxFish(int[][] grid) {
        int currentMax = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j]) continue;
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                } else {
                    currentMax = Math.max(dfs(i, j, visited, grid), currentMax);
                }
            }
        }
        return currentMax;
    }

    private int dfs(int i, int j, boolean[][] visited, int[][] grid) {
        visited[i][j] = true;

        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;

        if (i + 1 <= grid.length - 1 && grid[i + 1][j] != 0 && !visited[i + 1][j]) {
            first = dfs(i + 1, j, visited, grid);
        }
        if (i - 1 >= 0 && grid[i - 1][j] != 0 && !visited[i - 1][j] ) {
            second = dfs(i - 1, j, visited, grid);
        }
        if (j + 1 <= grid[0].length - 1 && grid[i][j + 1] != 0 && !visited[i][j + 1]) {
            third = dfs(i, j + 1, visited, grid);
        }
        if (j - 1 >= 0 && grid[i][j - 1] != 0 && !visited[i][j - 1] ) {
            fourth = dfs(i, j - 1, visited, grid);
        }
        return grid[i][j] + first + second + third + fourth;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {0, 2, 1, 0},
                {4, 0, 0, 3},
                {1, 0, 0, 4},
                {0, 3, 2, 0}
        };
        System.out.println(solution.findMaxFish(arr));
    }
}