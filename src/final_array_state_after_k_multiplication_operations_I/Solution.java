package final_array_state_after_k_multiplication_operations_I;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        Queue<int[]> queue = new PriorityQueue<>((first, second) -> {
            if (first[0] != second[0]) {
                return Integer.compare(first[0], second[0]);
            } else {
                return Integer.compare(first[1], second[1]);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            queue.offer(new int[] {nums[i], i});
        }

        for (int i = 0; i < k; i++) {
            int[] polled = queue.poll();
            int increasedVal = polled[0] * multiplier;
            nums[polled[1]] = increasedVal;
            polled[0] = increasedVal;
            queue.offer(polled);
        }
        return nums;
    }
}