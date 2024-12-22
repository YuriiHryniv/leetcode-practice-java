package word_break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        int left = 0;
        int right = left;
        String copyRes = s.intern();

        while (right <= s.length()) {
            if (set.contains(s.substring(left, right))) {
                copyRes = s.substring(right);
                left = right;
            }
            right++;
        }

        return copyRes.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("aaaaaaa", List.of("aaaa","aaa")));
    }
}