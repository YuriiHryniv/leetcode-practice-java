package check_if_array_is_sorted_and_rotated;


import java.util.Arrays;

class Solution {
    public boolean check(int[] nums) {
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        Arrays.sort(copy);
        for (int i = 0; i < nums.length; i++) {
            if (Arrays.equals(rotate(nums, i), copy)) {
                System.out.println(i);
                return true;
            }
        }
        return false;
    }

    private int[] rotate(int[] nums, int k) {
        int[] rotated = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            rotated[(i + k) % nums.length] = nums[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.check(new int[] {1,2,3}));

    }
}