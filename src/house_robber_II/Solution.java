package house_robber_II;

class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }

        int[] leftArr = new int[nums.length - 1];
        int[] rightArr = new int[nums.length - 1];

        System.arraycopy(nums, 0, leftArr, 0, nums.length - 1);
        System.arraycopy(nums, 1, rightArr, 0, nums.length - 1);

        return Math.max(dp(leftArr), dp(rightArr));
    }

    private int dp(int[] nums) {
        int[] memo = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }

        return robberDp(nums, memo, nums.length - 1);
    }

    private int robberDp(int[] nums, int[] memo, int index) {
        if (index == 0) {
            return nums[0];
        }
        if (index == 1) {
            return Math.max(nums[1], nums[0]);
        }
        if (memo[index] != -1) {
            return memo[index];
        }

        int robCurrent = robberDp(nums, memo, index - 2) + nums[index];
        int skipCurrent = robberDp(nums, memo, index - 1);

        memo[index] = Math.max(robCurrent, skipCurrent);

        return memo[index];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[] {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3}));
    }
}