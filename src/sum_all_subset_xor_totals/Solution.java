package sum_all_subset_xor_totals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public int subsetXORSum(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<>();
        dfs (0, 0, nums, integers);
        return integers.stream().mapToInt(i -> i).sum();
    }

    private void dfs(int index, int currentXor, int[] nums, List<Integer> res) {
        if (index == nums.length) {
            res.add(currentXor);
            return;
        }
        dfs(index + 1, currentXor ^ nums[index], nums, res);
        dfs(index + 1, currentXor, nums, res);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subsetXORSum(new int[]{3, 4, 5, 6, 7, 8})); // should be 480
    }
}