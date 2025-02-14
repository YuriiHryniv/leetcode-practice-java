package max_sum_of_pairs_equal_sum_digits;

import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int res = -1;
        for (int num : nums) {
            int digitSum = 0;

            List<Integer> value = map.get(digitSum);
            if (value == null) {
                List<Integer> set = new ArrayList<>();
                set.add(num);
                map.put(digitSum, set);
            } else {
                value.add(num);
                map.put(digitSum, value);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            if (entry.getValue().size() < 2) continue;
            List<Integer> list = entry.getValue();
            list.sort(Collections.reverseOrder());
            Integer first = list.get(0);
            Integer second = list.get(1);
            res = Math.max(res, first + second);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {0, 2, 1, 0},
                {4, 0, 0, 3},
                {1, 0, 0, 4},
                {0, 3, 2, 0}
        };
        System.out.println(solution.maximumSum(new int[] {229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401}));
    }
}