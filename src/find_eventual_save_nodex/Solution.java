package find_eventual_save_nodex;

import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        Map<Integer, List<Integer>> reversedMap = new HashMap<>();
        int[] inDegree = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) queue.offer(i);
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                inDegree[i]++;
            }
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                List<Integer> value = reversedMap.get(graph[i][j]);
                if (value == null) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(i);
                    reversedMap.put(graph[i][j], newList);
                } else {
                    value.add(i);
                }
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            List<Integer> values = reversedMap.get(node);

            if (values != null) {
                for (Integer value : values) {
                    inDegree[value]--;
                    if (inDegree[value] <= 0) queue.offer(value);
                }
            }

        }

        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] graph = {
                {1, 2, 3, 4},
                {1, 2},
                {3, 4},
                {0, 4},
                {}
        }; // should return [2,4,5,6]
        System.out.println(solution.eventualSafeNodes(graph));
    }
}