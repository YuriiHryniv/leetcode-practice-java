package redundant_connection;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                parent[x] = find(parent[x]); // path compression
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

        List<int[]> arr = new ArrayList<>(Arrays.asList(edges));

        for (int i = 0; i < edges.length; i++) {
            UnionFind uf = new UnionFind(edges.length + 1);
            List<int[]> firstList = new ArrayList<>(arr.subList(0, i));
            List<int[]> secondList = new ArrayList<>(arr.subList(i + 1, edges.length));

            firstList.addAll(secondList);

            for (int[] ints : firstList) {
                uf.union(ints[0], ints[1]);
            }

            boolean isCycled = false;
            List<Integer> res = new ArrayList<>();

            for (int k = 0; k < firstList.size(); k++) {
                res.add(uf.find(k));
            }



        }

        return null;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] edges = {{0, 1}, {1, 3}, {2, 3}};


        System.out.println(Arrays.toString(solution.findRedundantConnection(edges)));
    }
}