package count_days;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (first, second) -> {
            if (first[0] != second[0]) {
                return Integer.compare(first[0], second[0]);
            } else {
                return Integer.compare(first[1], second[1]);
            }
        });

        Deque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < meetings.length; i++) {
            if (deque.isEmpty()) {
                deque.offer(meetings[i]);
            } else if (meetings[i][0] <= deque.peekLast()[1]) {
                int[] last = deque.pollLast();
                deque.offer(new int[] {last[0], Math.max(last[1], meetings[i][1])});
            } else {
                deque.offer(meetings[i]);
            }
        }

        while (!deque.isEmpty()) {
            int[] interval = deque.poll();
            days -= interval[1] - interval[0] + 1;
        }

        return days;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {
                {15, 34},
                {5, 18},
                {9, 20},
                {1, 4},
                {6, 30},
                {6, 28},
                {25, 30},
                {23, 24}
        };
        //System.out.println(solution.countDays(10, new int[][]{{5, 7}, {1, 3}, {9, 10}}));
        //System.out.println(solution.countDays(34, new int[][]{{2,4}, {1, 3}}));
        System.out.println(solution.countDays(34, intervals));

    }
}