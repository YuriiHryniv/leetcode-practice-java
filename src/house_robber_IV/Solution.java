package house_robber_IV;

import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i: nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int res = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (isFeasible(nums, mid, k)) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return res;
    }

    public boolean isFeasible(int[] nums, int midpoint, int k) {
        int[] memo = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            memo[i] = -1;
        }

        return dp(nums, memo, midpoint, k);
    }

    private boolean dp(int[] nums, int[] memo, int midpoint, int k) {
        /*if (memo[midpoint] != -1 || memo[]) {

        }*/
        return true;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minCapability(new int[] {4,22,11,14,25}, 3));
    }
}