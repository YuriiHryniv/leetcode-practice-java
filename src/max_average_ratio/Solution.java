package max_average_ratio;

import java.util.*;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<double[]> queue = new PriorityQueue<>((first, second) -> {
            double firstRes = ((first[0] + 1) / (first[1] + 1)) - (first[0] / first[1]);
            double secondRes = ((second[0] + 1) / (second[1] + 1)) - (second[0] / second[1]);
            if (firstRes != secondRes) {
                return Double.compare(secondRes, firstRes);
            } else {
                return Double.compare(first[2], second[2]);
            }
        });
        for (int i = 0; i < classes.length; i++) {
            queue.offer(new double[] {classes[i][0], classes[i][1], i});
        }
        for (int i = 0; i < extraStudents; i++) {
            double[] clazz = queue.poll();
            clazz[0] = clazz[0] + 1;
            clazz[1] = clazz[1] + 1;
            queue.offer(clazz);
        }
        double averagePass = 0;


        while (!queue.isEmpty()) {
            double[] clazz = queue.poll();
            System.out.println(clazz[0] + " " + clazz[1]);

            averagePass += clazz[0] / clazz[1];
        }
        return averagePass / classes.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {2, 4},
                {3, 9},
                {4, 5},
                {2, 10}
        };
        System.out.println(solution.maxAverageRatio(arr, 4));
    }
}