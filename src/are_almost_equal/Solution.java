package are_almost_equal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int[] indexes = new int[2];
        int indexCounter = 0;
        int notEqualCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                notEqualCount++;
                indexes[indexCounter++] = i;
            }
            if (notEqualCount > 2) return false;
        }

        if (notEqualCount < 2) return false;

        char[] s1CharArr = s1.toCharArray();
        char[] s2CharArr = s2.toCharArray();

        char temp = s1CharArr[indexes[0]];
        s1CharArr[indexes[0]] = s1CharArr[indexes[1]];
        s1CharArr[indexes[1]] = temp;

        return Arrays.compare(s1CharArr, s2CharArr) == 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.areAlmostEqual("bank", "kanb"));

    }
}