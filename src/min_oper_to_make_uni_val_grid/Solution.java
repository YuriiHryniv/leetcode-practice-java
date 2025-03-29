package min_oper_to_make_uni_val_grid;

import java.util.Arrays;

class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] arr = new int[grid.length * grid[0].length];
        int arrCounter = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                arr[arrCounter++] = ints[j];
            }
        }

        Arrays.sort(arr);


        int medianNumber = arr[arr.length / 2];
        int operations = 0;
        for (int k : arr) {
            int abs = Math.abs(k - medianNumber);
            if (abs % x != 0) return -1;
            operations += abs / x;
        }
        return operations;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        /*int[][] arr = {
                {2, 4},
                {6, 8}
        };*/
        /*int[][] arr = {
                {1, 5},
                {2, 3}
        };*/
        /*int[][] arr = {
                {1, 2},
                {3, 4}
        };*/
        int[][] arr = {
                {141, 105, 69, 273, 681, 105, 933, 417, 309},
                {921, 657, 945, 717, 885, 57, 453, 921, 897},
                {681, 345, 657, 177, 897, 609, 465, 801, 429},
                {681, 993, 741, 885, 105, 981, 477, 249, 921},
                {369, 885, 945, 537, 45, 861, 381, 345, 417},
                {849, 849, 477, 513, 297, 609, 561, 177, 801},
                {561, 417, 129, 585, 621, 561, 261, 153, 501},
                {249, 777, 969, 249, 357, 393, 93, 321, 573},
                {525, 813, 381, 909, 825, 297, 681, 345, 813}
        };


        System.out.println(solution.minOperations(arr, 12)); // should be 16
    }
}