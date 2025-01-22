package map_of_highest_peak;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> queue = new LinkedList<>();

        int [][] arr = new int[isWater.length][isWater[0].length];

        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                arr[i][j] = -1;
            }
        }

        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    arr[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int row = polled[0];
            int column = polled[1];
            int incr = arr[polled[0]][polled[1]] + 1;

            if (row + 1 <= arr.length - 1 && arr[row + 1][column] == -1) {
                queue.offer(new int[]{row + 1, column});
                arr[row + 1][column] = incr;
            }
            if (row - 1 >= 0 && arr[row - 1][column] == -1) {
                queue.offer(new int[]{row - 1, column});
                arr[row - 1][column] = incr;
            }
            if (column + 1 <= arr[0].length - 1 && arr[row][column + 1] == -1) {
                queue.offer(new int[]{row, column + 1});
                arr[row][column + 1] = incr;
            }
            if (column - 1 >= 0 && arr[row][column - 1] == -1) {
                queue.offer(new int[]{row, column - 1});
                arr[row][column - 1] = incr;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.highestPeak(new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}})));
    }
}