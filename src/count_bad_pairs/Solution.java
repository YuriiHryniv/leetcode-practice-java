package count_bad_pairs;

import java.util.*;

class Solution {
    public long countBadPairs(int[] nums) {
        long badPairs = 0;
        Map<Integer, Integer> diffCount = new HashMap<>();

        for (int pos = 0; pos < nums.length; pos++) {
            int diff = pos - nums[pos];

            // Count of previous positions with same difference
            int goodPairsCount = diffCount.getOrDefault(diff, 0);

            // Total possible pairs minus good pairs = bad pairs
            badPairs += pos - goodPairsCount;

            // Update count of positions with this difference
            diffCount.put(diff, goodPairsCount + 1);
        }

        return badPairs;
    }

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        Solution solution = new Solution();
        //System.out.println(solution.countBadPairs(new int[]{1,2,3,4,5}));
        System.out.println(solution.countBadPairs(new int[]{4,1,3,3}));
    }
}