package min_length_str_after_operations;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumLength(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value >= 3) {
                if (value % 2 == 0) {
                    map.put(entry.getKey(), 2);
                } else {
                    map.put(entry.getKey(), 1);
                }
            }
        }

        int min = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            min += entry.getValue();
        }

        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumLength("aa"));
    }
}