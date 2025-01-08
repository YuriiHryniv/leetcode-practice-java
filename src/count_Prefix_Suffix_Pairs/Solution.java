package count_Prefix_Suffix_Pairs;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int sum = 0;
        for (int i = 0; i < words.length - 1; i++) {

            for (int j = i + 1; j < words.length; j++) {
                if (j == i) continue;
                if (words[j].endsWith(words[i]) && words[j].startsWith(words[i])) {
                    sum++;
                }
            }
        }
        return sum;
    }
}