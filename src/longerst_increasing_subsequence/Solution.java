package longerst_increasing_subsequence;

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6});
    }

}