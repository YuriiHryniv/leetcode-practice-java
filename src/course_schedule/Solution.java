package course_schedule;

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] inDegree = new int[numCourses];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            List<Integer> value = map.get(prerequisite[1]);
            inDegree[prerequisite[0]]++;

            if (value == null) {
                List<Integer> lst = new ArrayList<>();
                lst.add(prerequisite[0]);
                map.put(prerequisite[1], lst);
            } else {
                value.add(prerequisite[0]);
                map.put(prerequisite[1], value);

            }
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int untied = 0;

        while(!queue.isEmpty()) {
            Integer value = queue.poll();
            untied++;

            List<Integer> toDecrease = map.get(value);
            if (toDecrease == null) continue;
            for (int element : toDecrease) {
                inDegree[element]--;
                if (inDegree[element] == 0) queue.offer(element);
            }

        }

        return untied == numCourses;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {
                {1, 0},
                {1, 2},
                {3, 1},
                {3, 2},
                {2, 4},
                {4, 5},
                {2, 5}
        };

        System.out.println(solution.canFinish(6, graph));
    }
}