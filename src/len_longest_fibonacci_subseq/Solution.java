package len_longest_fibonacci_subseq;

import java.util.*;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int[][] dp = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length ; j++) {
                int diff = arr[j] - arr[i];
                Integer k  = map.get(diff);
                if (k != null && k < i) {
                    dp[i][j] = dp[k][i] + 1;
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = 2;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lenLongestFibSubseq(new int[] {1, 2, 3, 5}));
    }
}