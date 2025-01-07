package minimum_number_of_operations_to_move_all_to_each_box;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] minOperations(String boxes) {
        int[] left = new int[boxes.length()];
        int[] right = new int[boxes.length()];

        int leftNumberOfOnes = 0;
        int totalSumLeft = 0;

        for (int i = 0; i < boxes.length(); i++) {
            totalSumLeft += leftNumberOfOnes;
            left[i] = totalSumLeft;
            if (boxes.charAt(i) == '1') {
                leftNumberOfOnes++;
            }
        }

        int rightNumberOfOnes = 0;
        int totalSumRight = 0;

        for (int i = right.length - 1; i >= 0; i--) {
            totalSumRight += rightNumberOfOnes;
            right[i] = totalSumRight;
            if (boxes.charAt(i) == '1') {
                rightNumberOfOnes++;
            }
        }

        int[] res = new int[boxes.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] + right[i];
        }
        return res;
    }
}