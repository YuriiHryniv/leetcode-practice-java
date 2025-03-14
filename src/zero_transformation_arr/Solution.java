    package zero_transformation_arr;

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length];
        int[] res = new int[nums.length];

        diff[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        for (int[] query : queries) {
            diff[query[0]] -= 1;
            if (query[1] + 1 <= diff.length - 1) {
                diff[query[1] + 1] += 1;
            }
        }

        res[0] = diff[0];

        for (int i = 1; i < nums.length; i++) {
            res[i] = diff[i] + res[i - 1];

        }

        for (int i: res) {
            if (i > 0) return false;
        }

        return true;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isZeroArray(new int[] {4,3,2,1}, new int[][] {{1,3}, {0, 2}}));
    }
}