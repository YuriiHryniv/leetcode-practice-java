package find_number_distinct_color_among_balls;

import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> indexValueMap = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int[] query : queries) {

            Integer i = indexValueMap.get(query[0]);
            if (i != null) {
                Integer i1 = freqMap.get(i);
                i1--;
                if (i1 == 0) {
                    freqMap.remove(i);
                } else {
                    freqMap.put(i, i1);
                }
            }
            indexValueMap.put(query[0], query[1]);

            Integer value = freqMap.get(query[1]);
            if (value != null) {
                value++;
                freqMap.put(query[1], value);
            } else {
                freqMap.put(query[1], 1);
            }

            list.add(freqMap.size());

        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {0, 1},
                {1, 4},
                {1, 1},
                {1, 4},
                {1, 1}
        };

        int[][] arr1 = {
                {1, 4},
                {2, 5},
                {1, 3},
                {3, 4}
        };

        int[][] arr2 = {
                {0, 1},
                {1, 2},
                {2, 2},
                {3, 4},
                {4, 5}
        };

        int[][] arr3 = {
                {0, 1},
                {0, 4},
                {0, 4},
                {0, 1},
                {1, 2}
        };
        System.out.println(Arrays.toString(solution.queryResults(1, arr3)));
    }
}