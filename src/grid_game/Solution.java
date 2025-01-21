package grid_game;

class Solution {
    public long gridGame(int[][] grid) {
        long[][] bluePrefix = new long[grid.length][grid[0].length];
        long bLeft = 0;
        long bRight = grid[0].length - 1;

        long bLeftSum = 0;
        long bRightSum = 0;

        while (bLeft <= grid[0].length - 1 && bRight >= 0) {
            bLeftSum += grid[1][(int) bLeft];
            bluePrefix[1][(int) bLeft] = bLeftSum;

            bRightSum += grid[0][(int) bRight];
            bluePrefix[0][(int) bRight] = bRightSum;

            bLeft++;
            bRight--;
        }

        long leftBlue = bluePrefix[1][0] - grid[1][0];
        long rightBlue = bluePrefix[0][0] - grid[0][0];
        long currentMaxMinInBlue = Math.max(leftBlue, rightBlue);

        for (int i = 1; i <= grid[0].length - 1; i++) {
            leftBlue = bluePrefix[1][i] - grid[1][i];
            rightBlue = bluePrefix[0][i] - grid[0][i];

            if (Math.max(leftBlue, rightBlue) < currentMaxMinInBlue) {
                currentMaxMinInBlue = Math.max(leftBlue, rightBlue);
            }
        }
        return currentMaxMinInBlue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.gridGame(new int[][] {{1,3,1,15},{1,3,3,1}}));
        //System.out.println(solution.gridGame(new int[][] {{3,3,1},{8,5,2}}));
        //System.out.println(solution.gridGame(new int[][] {{2,5,4},{1,5,1}}));

        System.out.println(solution.gridGame(new int[][] {{20,3,20,17,2,12,15,17,4,15},{20,10,13,14,15,5,2,3,14,3}}));
    }
}