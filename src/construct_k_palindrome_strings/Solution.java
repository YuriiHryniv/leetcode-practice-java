package construct_k_palindrome_strings;

import java.util.*;

class Solution {
    public boolean canConstruct(String s, int k) {
        if (k == s.length()) return true;
        if (k > s.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer value = map.get(c);
            if (value == null) {
                map.put(c, 1);
            } else {
                map.put(c, ++value);
            }
        }

        int odd = 0;

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() % 2 == 1) odd++;
        }

        return odd <= k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("annabelle", 2));
    }
}