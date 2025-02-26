package most_profitable_path_in_tree;

import java.util.*;

class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            List<Integer> leftRight = map.get(edge[0]);
            List<Integer> rightLeft = map.get(edge[1]);

            if (leftRight == null) {
                leftRight = new ArrayList<>();
            }
            leftRight.add(edge[1]);
            map.put(edge[0], leftRight);

            if (rightLeft == null) {
                rightLeft = new ArrayList<>();
            }
            rightLeft.add(edge[0]);
            map.put(edge[1], rightLeft);
        }


        List<Integer> bobPath = new ArrayList<>();
        bobDfs(bob, -1, map, bobPath); // builds the path in reverse (from 0 up to bob)
        Collections.reverse(bobPath); // now the path is from bob to 0

        Map<Integer, Integer> bobTimeMap = new HashMap<>();
        for (int i = 0; i < bobPath.size(); i++) {
            bobTimeMap.put(bobPath.get(i), i);
        }


        return aliceDfs(new boolean[edges.length + 1], map, 0, amount[0], bobTimeMap, 0, amount);
    }

    private int aliceDfs(boolean[] visited, Map<Integer, List<Integer>> map, int alice, int aliceValue,
                         Map<Integer, Integer> bobTimeMap, int aliceTime, int[] amount) {
        visited[alice] = true;

        if (alice != 0 && map.get(alice).size() == 1) {
            return aliceValue;
        }

        int max = Integer.MIN_VALUE;
        for (Integer node : map.get(alice)) {
            if (!visited[node]) {
                int currentValue = amount[node];

                if (Objects.equals(bobTimeMap.get(node), aliceTime + 1)) {
                    currentValue /= 2;
                } else if (bobTimeMap.get(node) != null && bobTimeMap.get(node) < aliceTime + 1) {
                    currentValue = 0;
                }

                max = Math.max(max, aliceDfs(visited, map, node, aliceValue + currentValue,
                        bobTimeMap, aliceTime + 1, amount));
            }
        }
        return max;
    }

    private boolean bobDfs(int node, int parent, Map<Integer, List<Integer>> map, List<Integer> path) {
        if (node == 0) {
            path.add(node);
            return true;
        }
        for (int next : map.get(node)) {
            if (next == parent) continue; // avoid going back
            if (bobDfs(next, node, map, path)) {
                path.add(node);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] pairs = {
                {0, 2},
                {1, 4},
                {1, 6},
                {2, 4},
                {3, 6},
                {3, 7},
                {5, 7}
        };


        System.out.println(solution.mostProfitablePath(pairs, 4, new int[] {-6896,-1216,-1208,-1108,1606,-7704,-9212,-8258}));
    }
}