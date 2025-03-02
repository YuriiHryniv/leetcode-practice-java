package apply_operations_to_arr;

import com.sun.source.tree.BreakTree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.DelayQueue;

class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;

        // Step 1: Apply operations on the array
        for (int index = 0; index < n - 1; index++) {
            if (nums[index] == nums[index + 1] && nums[index] != 0) {
                nums[index] *= 2;
                nums[index + 1] = 0;
            }
        }

        // Step 2: Shift non-zero elements to the beginning
        int nonZeroIndex = 0;
        for (int iterateIndex = 0; iterateIndex < n; iterateIndex++) {
            if (nums[iterateIndex] != 0) {
                nums[nonZeroIndex++] = nums[iterateIndex];
            }
        }

        // Step 3: Fill the remaining positions with zeros
        while (nonZeroIndex < n) {
            nums[nonZeroIndex++] = 0;
        }

        return nums;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.applyOperations(new int[]{1,2,2,1,1,0})));

    }
}