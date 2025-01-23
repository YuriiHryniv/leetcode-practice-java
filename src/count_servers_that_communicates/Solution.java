package count_servers_that_communicates;

import java.util.*;

class Solution {
    public int countServers(int[][] grid) {
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> cols = new HashMap<>();


        for (int i = 0; i < grid.length; i++) {

            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)row.add(grid[i][j]);
            }
            rows.put(i, row);
        }

        for (int i = 0; i < grid[0].length; i++) {
            List<Integer> col = new ArrayList<>();

            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) col.add(grid[j][i]);
            }
            cols.put(i, col);
        }


        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                List<Integer> row = rows.get(i);
                List<Integer> col = cols.get(j);
                if (grid[i][j] == 1 && (row.size() >= 2 || col.size() >= 2)) res++;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countServers(new int[][]{{1, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
    }
}