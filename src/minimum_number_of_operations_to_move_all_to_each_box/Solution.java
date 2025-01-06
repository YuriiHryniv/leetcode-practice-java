package minimum_number_of_operations_to_move_all_to_each_box;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            int sum = 0;
            for (int j = 0; j < boxes.length(); j++) {
                if (j == i) continue;
                if (boxes.charAt(j) == '1') {
                    sum += Math.abs(i - j);
                }
            }
            res[i] = sum;
        }
        return res;
    }
}