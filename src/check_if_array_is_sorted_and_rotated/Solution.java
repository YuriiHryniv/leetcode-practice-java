package check_if_array_is_sorted_and_rotated;

import java.util.Arrays;

class Solution {
    public boolean check(int[] nums) {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        Arrays.sort(copy);

        int smallest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) smallest = i + 1;
        }
        return Arrays.equals(rotate(nums, smallest), copy);

    }

    private int[] rotate(int[] nums, int k) {
        int[] rotated = new int[nums.length];

        System.arraycopy(nums, 0, rotated, nums.length - k, k);
        System.arraycopy(nums, k, rotated, 0, nums.length - k);

        return rotated;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.check(new int[] {5,5,6,6,6,9,1,2}));
    }
}