package reorder_routes_to_make_all_paths_lead_to_zero;

import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        Set<Integer> visitedNodes = new HashSet<>();
        Map<Integer, List<Integer>> originalDirection = new HashMap<>();
        Map<Integer, List<Integer>> reverseDirection = new HashMap<>();
        fillHashMaps(connections, originalDirection, reverseDirection);
        return countDFS(visitedNodes, originalDirection, reverseDirection, 0);

    }

    private void fillHashMaps(int[][] connections, Map<Integer, List<Integer>> originalDirection, Map<Integer, List<Integer>> reverseDirection) {
        for (int[] connection : connections) {
            originalDirection.putIfAbsent(connection[1], new ArrayList<>());
            reverseDirection.putIfAbsent(connection[0], new ArrayList<>());
        }

        for (int[] connection : connections) {
            reverseDirection.get(connection[0]).add(connection[1]);
            originalDirection.get(connection[1]).add(connection[0]);
        }
    }

    private int countDFS(Set<Integer> visitedNodes, Map<Integer, List<Integer>> originalDirection, Map<Integer, List<Integer>> reverseDirection, int find) {
        int sum = 0;
        visitedNodes.add(find);
        List<Integer> directed = originalDirection.get(find);
        if (directed != null && !directed.isEmpty()) {
            for (Integer i : directed) {
                if (!visitedNodes.contains(i)) {
                    sum += countDFS(visitedNodes, originalDirection, reverseDirection, i);
                }
            }
        }
        List<Integer> reversed = reverseDirection.get(find);

        if (reversed != null && !reversed.isEmpty()) {
            for (Integer i : reversed) {
                if (!visitedNodes.contains(i)) {
                    sum += 1 + countDFS(visitedNodes, originalDirection, reverseDirection, i);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minReorder(3, new int[][]{
                {1, 0},
                {2, 0}
        }));
    }
}