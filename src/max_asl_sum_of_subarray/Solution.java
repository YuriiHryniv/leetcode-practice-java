package max_asl_sum_of_subarray;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int bestSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;

        for (int i: nums) {
            currentSum = Math.max(i, currentSum + i);
            bestSum = Math.max(currentSum, bestSum);
        }

        currentSum = 0;
        for (int i: nums) {
            currentSum = Math.min(i, currentSum + i);
            minSum = Math.min(minSum, currentSum);
        }

        return Math.max(Math.abs(bestSum), Math.abs(minSum));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxAbsoluteSum(new int[] {2,-5,1,-4,3,-2}));
    }
}