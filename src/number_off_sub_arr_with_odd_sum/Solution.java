package number_off_sub_arr_with_odd_sum;

import java.util.*;

class Solution {
    public int numOfSubarrays(int[] arr) {
        long oddCount = 0;
        long evenCount = 1;
        long sum = 0;
        long res = 0;
        int MOD = 1_000_000_007;

        for (long j : arr) {
            sum += j;
            if (sum % 2 == 0) {
                res = (res + oddCount) % MOD;
                evenCount++;
            } else {
                res = (res + evenCount) % MOD;
                oddCount++;
            }
        }

        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numOfSubarrays(new int[]{1,3,5}));
    }
}