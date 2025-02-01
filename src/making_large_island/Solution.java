package making_large_island;

import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int[][] islandIdArr = new int[grid.length][grid[0].length];
        Map<Integer, Integer> indexMap = new HashMap<>();
        int currentIslandId = 2;
        int currentMaxSum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && islandIdArr[i][j] == 0) {
                    indexMap.put(currentIslandId, islandIdDFS(i, j, islandIdArr, grid, currentIslandId++) + 1);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    currentMaxSum = Math.max(currentMaxSum, getIslandConnectSum(i, j, islandIdArr, indexMap));
                }
            }
        }

        if (currentMaxSum == 0 && grid[0].length > 0) {
            return  grid.length *grid[0].length;
        }

        return currentMaxSum;
    }

    private int islandIdDFS(int i, int j, int[][] islandIdArr, int[][] grid, int currentId) {
        islandIdArr[i][j] = currentId;

        int firstRes = 0;
        int secondRes = 0;
        int thirdRes = 0;
        int fourthRes = 0;

        if (i + 1 <= grid.length - 1 && grid[i + 1][j] == 1 && islandIdArr[i + 1][j] != currentId) {
            firstRes = islandIdDFS(i + 1, j, islandIdArr, grid, currentId) + 1;
        }
        if (i - 1 >= 0 && grid[i - 1][j] == 1 && islandIdArr[i - 1][j] != currentId) {
            secondRes = islandIdDFS(i - 1, j, islandIdArr, grid, currentId) + 1;
        }
        if (j + 1 <= grid[0].length - 1 && grid[i][j + 1] == 1 && islandIdArr[i][j + 1] != currentId) {
            thirdRes = islandIdDFS(i, j + 1, islandIdArr, grid, currentId) + 1;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1 && islandIdArr[i][j - 1] != currentId) {
            fourthRes = islandIdDFS(i, j - 1, islandIdArr, grid, currentId) + 1;
        }

        return firstRes + secondRes + thirdRes + fourthRes;
    }

    private int getIslandConnectSum(int i, int j, int[][] islandIdArr, Map<Integer, Integer> indexMap) {
        Set<Integer> addedIndexes = new HashSet<>();
        int upperRes = 0;
        int leftRes = 0;
        int rightRes = 0;
        int lowerRes = 0;

        if (i + 1 <= islandIdArr.length - 1 && islandIdArr[i + 1][j] != 0 && !addedIndexes.contains(islandIdArr[i + 1][j])) {
            lowerRes += indexMap.getOrDefault(islandIdArr[i + 1][j], 0);
            addedIndexes.add(islandIdArr[i + 1][j]);
        }
        if (i - 1 >= 0 && islandIdArr[i - 1][j] != 0 && !addedIndexes.contains(islandIdArr[i - 1][j])) {
            upperRes += indexMap.getOrDefault(islandIdArr[i - 1][j], 0);
            addedIndexes.add(islandIdArr[i - 1][j]);
        }
        if (j + 1 <= islandIdArr[0].length - 1 && islandIdArr[i][j + 1] != 0 && !addedIndexes.contains(islandIdArr[i][j + 1])) {
            rightRes += indexMap.getOrDefault(islandIdArr[i][j + 1], 0);
            addedIndexes.add(islandIdArr[i][j + 1]);
        }
        if (j - 1 >= 0 && islandIdArr[i][j - 1] != 0 && !addedIndexes.contains(islandIdArr[i][j - 1])) {
            leftRes += indexMap.getOrDefault(islandIdArr[i][j - 1], 0);
            addedIndexes.add(islandIdArr[i][j - 1]);
        }

        return upperRes + leftRes + rightRes + lowerRes + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid1 = {
                {1, 0},
                {0, 1}
        };

        // Grid 2: [[1,1],[1,0]]
        int[][] grid2 = {
                {1, 1},
                {1, 0}
        };

        // Grid 3: [[1,1],[1,1]]
        int[][] grid3 = {
                {1, 1},
                {1, 1}
        };


        int[][] array = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0}
        };

        System.out.println(solution.largestIsland(array));
    }
}