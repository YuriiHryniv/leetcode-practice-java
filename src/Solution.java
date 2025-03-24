import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    private static int minDistance(int[] dist, boolean[] sptSet) {
        // Initialize min value
         int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    // A utility function to print the constructed distance array
    private static void printSolution(int[] dist, int src) {
        System.out.println("Vertex \t\t Distance from Source (" + src + ")");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    // Implementation of Dijkstra's algorithm for a graph represented
    // using an adjacency matrix
    public static void dijkstra(int[][] graph, int src) {
        int V = graph.length; // Number of vertices in the graph

        // dist[] will hold the shortest distances from src to each vertex
        int[] dist = new int[V];

        // sptSet[v] will be true if vertex v is included in shortest path tree
        // or the shortest distance from src to v is finalized
        boolean[] sptSet = new boolean[V];

        // Initialize all distances as INFINITE and sptSet[] as false
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance of the source vertex from itself is 0
        dist[src] = 0;

        // Find the shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. minDistance() returns the index of the vertex
            // with the smallest distance value.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist[v] only if:
            // - it is not in sptSet
            // - there is an edge from u to v
            // - total weight of path from src to u + weight of edge u-v < dist[v]
            for (int v = 0; v < V; v++) {
                if (!sptSet[v]
                        && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print the constructed distance array
        printSolution(dist, src);
    }

    public static void main(String[] args) {
        // Example graph represented as a 2D matrix.
        // A 0 value indicates no direct edge between vertices.
        // Non-zero values represent edge weights.
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int sourceVertex = 0;
        dijkstra(graph, sourceVertex);

    }
}