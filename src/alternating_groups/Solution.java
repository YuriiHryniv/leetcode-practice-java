package alternating_groups;

import java.util.Arrays;

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0;
        int circularPairs = 1;

        for (int i = 1; i < colors.length + k - 1; i++) {
            if (colors[i % colors.length] != colors[(i - 1) % colors.length]) {
                circularPairs++;
            } else {
                circularPairs = 1;
            }
            if (circularPairs >= k) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfAlternatingGroups(new int[]{0,1,0,0,1,0,1}, 6));

    }
}