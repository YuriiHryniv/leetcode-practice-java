package count_containing_vowels_and_k;

import java.util.*;

class Solution {
    public int numberOfSubstrings(String s) {
        int[] precomputed = new int[s.length() + 1];
        int res = 0;

        Set<Character> threeSet = new HashSet<>();
        threeSet.add('a');
        threeSet.add('b');
        threeSet.add('c');

        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            if (threeSet.contains(s.charAt(right))) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (map.size() == 3) {
                precomputed[left] = right;
                Integer count = map.get(s.charAt(left));
                if (count == 1) {
                    map.remove(s.charAt(left));
                } else {
                    map.put(s.charAt(left), count - 1);
                }
                left++;
            }
            right++;

        }

        for (int j : precomputed) {
            if (j != 0) {
                res += s.length() - j;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubstrings("abc"));
    }
}