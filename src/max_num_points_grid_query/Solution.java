package max_num_points_grid_query;

import java.util.*;

public class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int[] res = new int[queries.length];
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Map<Integer, List<Integer>> queryIndexMap = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            List<Integer> value = queryIndexMap.get(queries[i]);
            if (value == null) {
                value = new ArrayList<>();
            }
            value.add(i);
            queryIndexMap.put(queries[i], value);
        }

        Arrays.sort(queries);

        PriorityQueue<int[]> queue = new PriorityQueue<>((first, second) -> Integer.compare(first[2], second[2]));
        queue.offer(new int[] {0, 0, grid[0][0]});
        int cumulativeRes = 0;

        for (int i = 0; i < queries.length; i++) {

            cumulativeRes += bfs(grid, queries[i], visited, queue);
            List<Integer> integers = queryIndexMap.get(queries[i]);
            for (Integer integer : integers) {
                res[integer] = cumulativeRes;

            }

        }

        return res;
    }

    private int bfs(int[][] grid, int query, boolean[][] visited, Queue<int[]> queue) {
        int res = 0;

        while (!queue.isEmpty() && queue.peek()[2] < query) {


            int[] currentPolled = queue.poll();


            res++;
            visited[currentPolled[0]][currentPolled[1]] = true;

            if (currentPolled[0] + 1 <= grid.length - 1 && !visited[currentPolled[0] + 1][currentPolled[1]]) {
                queue.offer(new int[] {currentPolled[0] + 1, currentPolled[1], grid[currentPolled[0] + 1][currentPolled[1]]});
                visited[currentPolled[0] + 1][currentPolled[1]] = true;

            }
            if (currentPolled[0] - 1 >= 0 && !visited[currentPolled[0] - 1][currentPolled[1]]) {
                queue.offer(new int[] {currentPolled[0] - 1, currentPolled[1], grid[currentPolled[0] - 1][currentPolled[1]]});
                visited[currentPolled[0] - 1][currentPolled[1]] = true;

            }
            if (currentPolled[1] + 1 <= grid[0].length -1 && !visited[currentPolled[0]][currentPolled[1] + 1] ) {
                queue.offer(new int[] {currentPolled[0], currentPolled[1] + 1, grid[currentPolled[0]][currentPolled[1] + 1]});
                visited[currentPolled[0]][currentPolled[1] + 1] = true;

            }
            if (currentPolled[1] - 1 >= 0 && !visited[currentPolled[0]][currentPolled[1] - 1]) {
                queue.offer(new int[] {currentPolled[0], currentPolled[1] - 1, grid[currentPolled[0]][currentPolled[1] - 1]});
                visited[currentPolled[0]][currentPolled[1] - 1] = true;

            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid = {
                {1, 2, 4},
                {3, 5, 8},
                {7, 6, 9}
        };
        int[] queries = {1, 2, 2, 4, 10};


        System.out.println(Arrays.toString(solution.maxPoints(grid, queries)));

    }
}
