package put_marbles_in_bags;

import java.util.Arrays;

class Solution {

    public long putMarbles(int[] weights, int k) {
        if (weights.length <= k) return 0;

        int baseValue = weights[0] + weights[weights.length -1];

        int[] cuts = new int[weights.length - 1];

        for (int i = 0; i < weights.length - 1; i++) {
            cuts[i] = weights[i] + weights[i + 1] + baseValue;
        }

        Arrays.sort(cuts);

        int amountOfCuts = k - 1;

        int maxScores = 0;
        int maxScoreIndex = cuts.length - 1;
        int minScores = 0;
        int minScoreIndex = 0;

        while (amountOfCuts > 0) {
            minScores += cuts[minScoreIndex++];
            maxScores += cuts[maxScoreIndex--];
            amountOfCuts--;
        }

        return maxScores - minScores;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.putMarbles(new int[] {1,3,5,1}, 2);
    }
}