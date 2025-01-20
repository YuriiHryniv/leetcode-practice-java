package first_completely_painted_row_or_column;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> column = new HashMap<>();
        int[] rowFreq = new int[mat.length];
        int[] columnFreq = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                row.put(mat[i][j], i);
                column.put(mat[i][j], j);
            }
        }

        int index = 0;
        int res = 0;

        while (index < arr.length) {
            int currentRow = row.get(arr[index]);
            int currentColumn = column.get(arr[index]);

            columnFreq[currentColumn]++;
            rowFreq[currentRow]++;

            if (columnFreq[currentColumn] == mat.length || rowFreq[currentRow] == mat[0].length) {
                res = index;
                break;
            }

            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstCompleteIndex(new int[] {6,2,3,1,4,5}, new int[][] {{5, 1},{2, 4}, {6, 3}}));
    }
}