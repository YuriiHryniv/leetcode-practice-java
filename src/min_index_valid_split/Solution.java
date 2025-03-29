package min_index_valid_split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (Integer num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int dominant = -1;
        int max = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                dominant = entry.getKey();
            }
        }

        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == dominant) indexes.add(i);
        }

        for (int i = 0; i < indexes.size(); i++) {
            List<Integer> left = nums.subList(0, indexes.get(i) + 1);
            List<Integer> right = nums.subList(indexes.get(i) + 1, nums.size());
            if ((i + 1) * 2 > left.size() && (indexes.size() - i - 1) * 2 > right.size()) return indexes.get(i);
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumIndex(List.of(3,3,3,3,7,2,2)));
    }
}
