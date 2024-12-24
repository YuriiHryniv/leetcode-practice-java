package word_break;

import java.util.Collections;
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
            if (set.contains(s.substring(left, right)) && !isPartOfLargerWord(s.substring(left, right), wordDict, copyRes.length())) {
                copyRes = s.substring(right);
                left = right;
            }
            right++;
        }

        return copyRes.isEmpty();
    }

    private boolean isPartOfLargerWord(String substring, List<String> wordDict, int targetLength) {
        if (substring.length() == targetLength) {
            return false;
        }
        boolean isPart = false;

        for (String word: wordDict) {
            if (word.startsWith(substring) && !substring.equals(word) && word.length() <= targetLength) {
                isPart = true;
                break;
            }
        }
        return isPart;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("aaaaaaa", List.of("aaaa","aaa")));
    }
}