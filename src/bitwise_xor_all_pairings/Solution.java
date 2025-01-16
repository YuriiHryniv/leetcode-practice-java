package bitwise_xor_all_pairings;

import java.util.Stack;

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        if (nums1.length % 2 == 1 && nums2.length % 2 == 0) {
            int res = nums2[0];
            for (int i = 1; i < nums2.length; i++) {
                res = res ^ nums2[i];
            }
            return res;
        } else if (nums2.length % 2 == 1 && nums1.length % 2 == 0) {
            int res = nums1[0];
            for (int i = 1; i < nums1.length; i++) {
                res = res ^ nums1[i];
            }
            return res;
        } else if (nums2.length % 2 == 1 && nums1.length % 2 == 1) {
            int firstRes = nums1[0];
            int secondRes = nums2[0];
            for (int i = 1; i < nums1.length; i++) {
                firstRes = firstRes ^ nums1[i];
            }
            for (int i = 1; i < nums2.length; i++) {
                secondRes = secondRes ^ nums2[i];
            }
            return firstRes ^ secondRes;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.xorAllNums(new int[] {25,29,3,10,0,15,2}, new int[] {12}));

    }
}