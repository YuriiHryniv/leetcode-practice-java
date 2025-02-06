package tuple_of_the_same_product;


import java.util.*;

class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                freq.put(product, freq.getOrDefault(product, 0) + 1);
            }
        }

        int combinationSum = 0;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int size = entry.getValue();
            combinationSum += (size * 2) * (2 * (size - 1));
        }
        return combinationSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tupleSameProduct(new int[]{1,2,4,5,10}));
    }
}