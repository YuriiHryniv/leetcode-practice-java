package longest_strictly_increasing_decreasing;

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 0) return 0;
        boolean[] decrArr = new boolean[nums.length];
        boolean[] incrArr = new boolean[nums.length];

        decrArr[0] = true;
        incrArr[0] = true;

        for (int i = 1; i < nums.length; i++) {
            decrArr[i] = nums[i] < nums[i - 1];
            incrArr[i] = nums[i] > nums[i - 1];
        }

        int longestIncreasing = 1;
        int longestDecreasing = 1;

        int currentIncreasing = 1;
        int currentDecreasing = 1;

        for (int i = 1; i < nums.length; i++) {
            if (incrArr[i]) {
                currentIncreasing++;
            } else {
                longestIncreasing = Math.max(longestIncreasing, currentIncreasing);
                currentIncreasing = 1;
            }

            if (decrArr[i]) {
                currentDecreasing++;
            } else {
                longestDecreasing = Math.max(currentDecreasing, longestDecreasing);
                currentDecreasing = 1;
            }
        }

        longestDecreasing = Math.max(currentDecreasing, longestDecreasing);
        longestIncreasing = Math.max(longestIncreasing, currentIncreasing);

        return Math.max(longestIncreasing, longestDecreasing);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestMonotonicSubarray(new int[]{1,4,3,3,2}));
    }
}