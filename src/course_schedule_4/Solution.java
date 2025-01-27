package course_schedule_4;

import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[][] isReachable = new boolean[numCourses][numCourses];
        List<Integer>[] dp = new ArrayList[numCourses];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            List<Integer> list = map.get(prerequisites[i][1]);
            if (list == null) {
                List<Integer> newList = new ArrayList<>();
                newList.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], newList);
            } else {
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            Integer polled = queue.poll();

            List<Integer> toBePolled = map.get(polled);
            if (toBePolled == null) continue;
            for (Integer value: toBePolled) {
                dp[value].addAll(dp[polled]);
                dp[value].add(polled);
                --inDegree[value];
                if (inDegree[value] == 0) queue.offer(value);
            }
        }

        for (int i = 0; i < dp.length; i++) {

            for (Integer value: dp[i]) {
                isReachable[i][value] = true;
            }
        }

        List<Boolean> res = new ArrayList<>();

        for (int[] query : queries) {
            res.add(isReachable[query[0]][query[1]]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int[][] array = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4}
        };*/

        int[][] array = {
                {1, 2},
                {1, 0},
                {2, 0}
        };

       /* int[][] array2 = {
                {0, 4},
                {4, 0},
                {1, 3},
                {3, 0}
        };*/

        int[][] array2 = {
                {1, 0},
                {1, 2}
        };

        System.out.println(solution.checkIfPrerequisite(5, array, array2));
    }
}