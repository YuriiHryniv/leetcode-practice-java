package zero_array_transformation;

class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length];
        int [] res = new int[nums.length];
        int [] bool = new int[nums.length];

        diff[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }

        for (int i = 0; i < queries.length; i++) {
            diff[queries[i][0]] -= queries[i][2];

            if (queries[i][1]  + 1 <= nums.length - 1) {
                diff[queries[i][1]] += queries[i][2];
            }
        }

        return 1;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minZeroArray(new int[]{2,0,2}, new int [][] {{0,2,1} , {0,2,1}, {1,1,3}}));
    }
}