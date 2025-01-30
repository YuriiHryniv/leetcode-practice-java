package redundant_connection;

import java.util.Arrays;

class Solution {

    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                // union by rank
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {

        UnionFind uf = new UnionFind(edges.length + 1);

        for (int[] edge : edges) {
            if (uf.find(edge[0]) == uf.find(edge[1])) {
                return edge;
            } else {
                uf.union(edge[0], edge[1]);
            }
        }

        return edges[edges.length - 1];
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5}
        };
        int[][] arr1 = {
                {1, 2},
                {1, 3},
                {2, 3}
        };


        System.out.println(Arrays.toString(solution.findRedundantConnection(arr)));
    }
}