package maximum_value_of_ordered_triplet;

import java.util.*;

class Solution {
    public long maximumTripletValue(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        int maxTriplet = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (maxDiff * nums[i] > maxTriplet){
                maxTriplet = maxDiff * nums[i];
            }
            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
            if (maxValue - nums[i] > maxDiff) {
                maxDiff =  maxValue - nums[i];
            }
        }

        return maxTriplet;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {0, 2, 1, 0},
                {4, 0, 0, 3},
                {1, 0, 0, 4},
                {0, 3, 2, 0}
        };
        System.out.println(solution.maximumTripletValue(new int[] {12,6,1,2,7}));
    }
}