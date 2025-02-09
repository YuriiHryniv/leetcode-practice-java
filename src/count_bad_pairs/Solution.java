package count_bad_pairs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public long countBadPairs(int[] nums) {
        long totalPairs = (long) nums.length * (nums.length - 1) / 2;
        long totalGoodPairs = 0;
        Map<Long, Long> map = new HashMap<>();
        for (long i = 0; i < nums.length; i++) {
            long pair = nums[(int) i] - i;
            Long l = map.get(pair);
            if (l != null) {
                map.put(pair, ++l);
            } else {
                map.put(pair, 1L);
            }
        }

        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                totalGoodPairs += entry.getValue() * (entry.getValue() - 1) / 2;
            }
        }

        return totalPairs - totalGoodPairs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.countBadPairs(new int[]{1,2,3,4,5}));
        System.out.println(solution.countBadPairs(new int[]{4,1,3,3}));
    }
}