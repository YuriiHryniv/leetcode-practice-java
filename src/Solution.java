import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    private static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack, adj);
            }
        }
        stack.push(node);
    }

    public static List<Integer> topologicalSort(int numNodes, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numNodes];

        for (int i = 0; i < numNodes; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack, adj);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        int numNodes = 6;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        List<Integer> sortedOrder = topologicalSort(numNodes, adj);
        System.out.println("Topological Sort: " + sortedOrder);
    }
}