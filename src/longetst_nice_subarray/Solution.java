package longetst_nice_subarray;

import java.util.*;

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int counter = 0;
        int sum = 0;
        int j = 0;
        int finalCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            int res = nums[i] & sum;
            if (res == 0) {
                 counter++;
                finalCounter = Math.max(counter, finalCounter);
                sum |= nums[i];
            } else {
                while (res != 0) {
                    sum &= nums[j];
                    counter--;
                    res = nums[i] & sum;
                    j++;
                    if (j == i) {
                        sum |= nums[j];
                        counter++;
                        break;
                    }
                }
            }
        }
        return finalCounter;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestNiceSubarray(new int[]{1,3,8,48,10}));
    }
}