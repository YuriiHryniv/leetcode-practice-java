package minOperations;

import java.util.PriorityQueue;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> queue = new PriorityQueue<>(Long::compare);

        for (long num : nums) {
            queue.offer(num);
        }

        if (queue.size() < 2) return 0;

        int counter = 0;
        while (queue.peek() < k) {
            long first = queue.poll();
            long second = queue.poll();

            queue.offer(Math.min(first, second) * 2 + Math.max(first, second));

            counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{999999999,999999999,999999999}, 1000000000));
    }
}