package word_subset;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        Map<Character, Integer> desiredFreq = new HashMap<>();
        Map<Character,Integer> localFreq = new HashMap<>();
        String desiredString = Arrays.stream(words2).collect(Collectors.joining(" "));;

        for (int i = 0; i < desiredString.length(); i++) {
            char c = desiredString.charAt(i);
            if (c == ' ') {
                merge(localFreq, desiredFreq);
                localFreq.clear();
                continue;
            }
            Integer value = localFreq.get(c);
            if (value == null) {
                localFreq.put(c, 1);
            }else {
                localFreq.put(c, ++value);
            }
        }
        merge(localFreq, desiredFreq);
        Map<Character, Integer> currentFreq = new HashMap<>();

        for (String str: words1) {
            currentFreq.clear();

            for (int i = 0; i < str.length(); i++) {
                Integer value = currentFreq.get(str.charAt(i));
                if (value == null) {
                    currentFreq.put(str.charAt(i), 1);
                } else {
                    currentFreq.put(str.charAt(i), ++value);
                }
            }

            if (isSubset(currentFreq, desiredFreq)) {
                res.add(str);
            }
        }

        return res;
    }

    private void merge(Map<Character, Integer> local, Map<Character, Integer> desiredFreq) {
        for (Map.Entry<Character, Integer> entry : local.entrySet()) {
            Integer value = desiredFreq.get(entry.getKey());
            if (value == null) {
                desiredFreq.put(entry.getKey(), entry.getValue());
            } else if (value < entry.getValue()) {
                desiredFreq.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private boolean isSubset(Map<Character, Integer> currentFreq, Map<Character, Integer> desiredFreq) {
        for (Map.Entry<Character, Integer> entry: desiredFreq.entrySet()) {
            Integer periodicity = currentFreq.get(entry.getKey());
            if (periodicity == null || periodicity < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"lo","eeo", "oo"}));
    }
}