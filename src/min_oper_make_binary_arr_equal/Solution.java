package min_oper_make_binary_arr_equal;

import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > nums.length - 3 && nums[i] == 0) {
                return -1;
            }
            if (nums[i] == 0) {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[] {0,1,0})); // should be 16
    }
}