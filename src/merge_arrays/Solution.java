package merge_arrays;

import java.util.*;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> keyToSum = new TreeMap<>();

        for (int[] nums : nums1) {
            keyToSum.put(nums[0], nums[1]);
        }

        for (int[] nums : nums2) {
            keyToSum.put(nums[0], keyToSum.getOrDefault(nums[0], 0) + nums[1]);
        }

        List<int[]> mergedList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : keyToSum.entrySet()) {
            mergedList.add(new int[] { entry.getKey(), entry.getValue() });
        }

        int[][] mergedArray = new int[mergedList.size()][2];
        for (int i = 0; i < mergedList.size(); i++) {
            mergedArray[i] = mergedList.get(i);
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums1 = {
                {1, 2},
                {2, 3},
                {4, 5}
        };

        int[][] nums2 = {
                {1, 4},
                {3, 2},
                {4, 1}
        };
        System.out.println(Arrays.deepToString(solution.mergeArrays(nums1, nums2)));
    }
}