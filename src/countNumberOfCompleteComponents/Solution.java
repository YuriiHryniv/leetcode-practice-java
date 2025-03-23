package countNumberOfCompleteComponents;

import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        int completeComponents = 0;

        Map<Integer, List<Integer>> edgeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            edgeMap.put(i, new ArrayList<>());
        }

        for (int[] edge: edges) {
            edgeMap.get(edge[1]).add(edge[0]);
            edgeMap.get(edge[0]).add(edge[1]);

        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                List<Integer> componentNodes = new ArrayList<>();
                int nodes = 0;
                int localEdges = 0;

                queue.offer(i);

                while (!queue.isEmpty()) {
                    int currentNode = queue.poll();
                    if (!visited[currentNode]) {
                        componentNodes.add(currentNode);
                        nodes++;

                        visited[currentNode] = true;
                        List<Integer> currentEdgesLeft = edgeMap.get(currentNode);
                        for (Integer node : currentEdgesLeft) {
                            queue.offer(node);
                        }
                    }
                }
                int edgesInThisComponent = 0;
                for (Integer node: componentNodes) {
                    edgesInThisComponent += edgeMap.get(node).size();
                }
                int edgesNeeded = nodes * (nodes - 1) / 2;
                if (edgesInThisComponent  / 2== edgesNeeded) completeComponents++;
            }
        }
        return completeComponents;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4}
        };;*/
        int[][] edges = {
                {1, 0},
                {2, 1}
        };;
        System.out.println(solution.countCompleteComponents(3, edges));
    }
}