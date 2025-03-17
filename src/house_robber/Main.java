package house_robber;

public class Main {
    public int rob(int[] nums) {
        // Initialize the memoization array with a special value (e.g., -1) indicating that the value hasn't been computed.
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }
        return getMaxProfit(nums.length - 1, nums, memo);
    }

    public int getMaxProfit(int index, int[] nums, int[] memo) {
        if (index < 0) {
            return 0;
        }
        if (index == 0) {
            return nums[0];
        }
        if (index == 1) {
            return Math.max(nums[0], nums[1]);
        }

        // Check if the result is already computed
        if (memo[index] != -1) {
            return memo[index];
        }

        // Recursively compute the result if not already computed
        int robCurrent = getMaxProfit(index - 2, nums, memo) + nums[index];
        int skipCurrent = getMaxProfit(index - 1, nums, memo);

        // Store the result in memo before returning
        memo[index] = Math.max(robCurrent, skipCurrent);
        return memo[index];
    }
}
