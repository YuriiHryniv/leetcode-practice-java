package min_cost_to_make_least_one_valid_path;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int minCost(int[][] grid) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(ints -> ints[2]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        priorityQueue.add(new int[]{0, 0, 0});
        int res = 0;

        while (!priorityQueue.isEmpty()) {
            int[] polled = priorityQueue.poll();
            visited[polled[0]][polled[1]] = true;

            if (polled[0] == grid.length - 1 && polled[1] == grid[0].length - 1) break;
            res += polled[2];

            if (polled[1] + 1 <= grid[0].length - 1 && !visited[polled[0]][polled[1] + 1]) {
                int cost = 0;
                if (grid[polled[0]][polled[1]] != 1) {
                    ++cost;
                }
                priorityQueue.offer(new int[]{polled[0], polled[1] + 1,cost});
            }
            if (polled[1] - 1 >= 0 && !visited[polled[0]][polled[1] - 1]) {
                int cost = 0;
                if (grid[polled[0]][polled[1]] != 2) {
                    ++cost;
                }
                priorityQueue.offer(new int[]{polled[0], polled[1] - 1,cost});
            }
            if (polled[0] + 1 <= grid.length - 1 && !visited[polled[0] + 1][polled[1]]) {
                int cost = 0;
                if (grid[polled[0] + 1][polled[1]] != 3) {
                    ++cost;
                }
                priorityQueue.offer(new int[]{polled[0] + 1, polled[1],cost});
            }
            if (polled[0] - 1 >= 0 && !visited[polled[0] - 1][polled[1]]) {
                int cost = 0;
                if (grid[polled[0] - 1][polled[1]] != 4) {
                    ++cost;
                }
                priorityQueue.offer(new int[]{polled[0] - 1, polled[1], cost});
            }

        }
        return res;
        //return bfsCount(visited, priorityQueue, grid, 0, 0);
    }

    private int bfsCount(boolean[][] visited, PriorityQueue<int[]> priorityQueue, int[][] grid, int start, int end) {
        if (start == grid.length - 1 && end == grid[0].length - 1) {
            return 0;
        }

        if (end + 1 <= grid[0].length - 1 && !visited[start][end + 1]) {
            int cost = 0;
            if (grid[start][end] != 1) {
                ++cost;
            }
            priorityQueue.offer(new int[]{start, end + 1,cost});
        }
        if (end - 1 >= 0 && !visited[start][end - 1]) {
            int cost = 0;
            if (grid[start][end] != 2) {
                ++cost;
            }
            priorityQueue.offer(new int[]{start, end - 1,cost});
        }
        if (start + 1 <= grid.length - 1 && !visited[start + 1][end]) {
            int cost = 0;
            if (grid[start + 1][end] != 3) {
                ++cost;
            }
            priorityQueue.offer(new int[]{start + 1, end,cost});
        }
        if (start - 1 >= 0 && !visited[start - 1][end]) {
            int cost = 0;
            if (grid[start - 1][end] != 4) {
                ++cost;
            }
            priorityQueue.offer(new int[]{start - 1, end, cost});
        }

        int[] polled = priorityQueue.poll();
        visited[start][end] = true;

        if (isSameDirection(grid, start, end, polled[0], polled[1])) {
            return bfsCount(visited, priorityQueue, grid, polled[0], polled[1]);
        } else {
            return bfsCount(visited, priorityQueue, grid, polled[0], polled[1]) + 1;
        }
    }

    private boolean isSameDirection(int[][] grid, int start, int end, int polledStart, int polledEnd) {
        if (grid[start][end] == 1 && polledEnd == end + 1) {
            return true;
        } else if (grid[start][end] == 2 && polledEnd == end - 1) {
            return true;
        } else if (grid[start][end] == 3 && polledStart == start + 1) {
            return true;
        } else return grid[start][end] == 4 && polledStart == start - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCost(new int[][] {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}})); // SHOULD BE 3
        //System.out.println(solution.minCost(new int[][] {{1,2},{4,3}}));
        /*System.out.println(solution.minCost(new int[][] {{1, 1, 3},
                {2, 2, 2},
                {4, 4, 1}}));*/
    }
}