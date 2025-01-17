package xor_all_nums;

import java.util.Arrays;

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int[] res = new int[derived.length];
        res[0] = 1;
        for (int i = 1; i < derived.length; i++) {
            res[i] = derived[i - 1] ^ res[i - 1];
        }
        return isValid(res, derived);
    }

    private boolean isValid(int[] res, int[] derived) {
        int[] temp = new int[res.length];
        for (int i = 0; i < res.length - 1; i++) {
            temp[i] = res[i] ^ res[i + 1];
        }
        temp[res.length - 1] = res[res.length - 1] ^ res[0];

        for (int i = 0; i < res.length; i++) {
            if (temp[i] != derived[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.doesValidArrayExist(new int[] {1, 1}));
    }
}