package questions_with_brainpower;

class Solution {

    public long mostPoints(int[][] questions) {
        int[] dp = new int[questions.length];
        int max = Integer.MIN_VALUE;

        for (int i = questions.length - 1; i >= 0; i--) {

            if (i + 1 <= questions.length - 1) {
                dp[i] += Math.max(questions[i][0], dp[i + 1]);
            } else {
                dp[i] = questions[i][0];
            }

            int secondIndex = i + 1 + questions[i][1];

            if (secondIndex <= questions.length - 1) {
                dp[i] = Math.max(dp[i], dp[secondIndex] + questions[i][0]);
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] arr = {
                {21, 5},
                {92, 3},
                {74, 2},
                {39, 4},
                {58, 2},
                {5, 5},
                {49, 4},
                {65, 3}
        };


        solution.mostPoints(arr);
    }
}