package tuple_of_the_same_product;


import java.util.*;

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i == j) continue;
                int key = nums[i] * nums[j];

                List<int[]> currentKey = map.get(key);
                if (currentKey == null) {
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[] {nums[i], nums[j]});
                    map.put(key, list);
                } else {
                    currentKey.add(new int[] {nums[i], nums[j]});
                    map.put(key, currentKey);
                }
            }
        }

        int combinationSum = 0;

        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            List<int[]> value = entry.getValue();
            int size = value.size();
            combinationSum += (size * 2) * (2 * (size - 1));
        }
        return combinationSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tupleSameProduct(new int[]{1,2,4,5,10}));
    }
}