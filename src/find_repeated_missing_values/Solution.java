package find_repeated_missing_values;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] freq = new int[grid.length * grid[0].length + 1];
        int[] res = new int[2];

        for (int[] arr: grid) {
            for (int element: arr) {
                freq[element]++;
                if (freq[element] == 2) {
                    res[0] = element;
                }
            }
        }

        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                res[1] = i;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {
                {9, 1, 7},
                {8, 9, 2},
                {3, 4, 6}
        };

        System.out.println(Arrays.toString(solution.findMissingAndRepeatedValues(array)));
    }
}