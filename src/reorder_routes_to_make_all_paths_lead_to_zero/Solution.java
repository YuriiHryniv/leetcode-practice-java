package reorder_routes_to_make_all_paths_lead_to_zero;

import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        Set<Integer> currentAllowedConnection = new HashSet<>();
        currentAllowedConnection.add(0);

        List<Integer> res = new ArrayList<>();

        dfs(currentAllowedConnection, connections, res, new HashSet<>());

        return res.size();

    }

    private void dfs(Set<Integer> currentAllowedConnections, int[][] connections, List<Integer> res, Set<Integer> reorderedSet) {
        while (reorderedSet.size() != connections.length) {
            for (int i = 0; i < connections.length; i++) {
                if (reorderedSet.contains(i)) {
                    continue;
                }
                if (currentAllowedConnections.contains(connections[i][1]) || currentAllowedConnections.contains(connections[i][0])) {
                    if (!currentAllowedConnections.contains(connections[i][1])) {
                        //int temp = connections[i][1];
                        //connections[i][1] = connections[i][0];
                        //connections[i][0] = temp;
                        res.add(1);
                        reorderedSet.add(i);
                        currentAllowedConnections.add(connections[i][1]);

                    } else {
                        currentAllowedConnections.add(connections[i][0]);
                        reorderedSet.add(i);
                    }

                }
            }
        }
    }
}