package word_break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                } else {
                    dp[i] = false;
                }
            }

        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("leetcode", List.of("leet","code")));
    }
}