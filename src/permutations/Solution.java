package permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();

        dfs(resList, new ArrayList<>(), nums);
        return resList;
    }

    private void dfs(List<List<Integer>> res, List<Integer> localRes, int[] nums) {
        if (nums == null || nums.length == 0) {
            res.add(localRes);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];

            int[] leftArr = Arrays.copyOfRange(nums, 0, i);
            int[] rightArr = Arrays.copyOfRange(nums, i + 1, nums.length);

            int[] merged = new int[nums.length - 1];

            System.arraycopy(leftArr, 0, merged, 0, leftArr.length);

            System.arraycopy(rightArr, 0, merged, leftArr.length, rightArr.length);

            localRes.add(currentNumber);

            dfs(res, new ArrayList<>(localRes), merged);

            localRes.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.permute(new int[] {1,2,3}));
    }
}