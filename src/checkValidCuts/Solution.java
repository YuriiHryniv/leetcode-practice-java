package checkValidCuts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> xIntervals = new ArrayList<>();
        List<int[]> yIntervals = new ArrayList<>();

        for (int[] rectangle : rectangles) {
            xIntervals.add(new int[] {rectangle[0], rectangle[2]});
            yIntervals.add(new int[] {rectangle[1], rectangle[3]});
        }

        xIntervals.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        yIntervals.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int xParts = mergeIntervals(xIntervals);
        int yParts = mergeIntervals(yIntervals);

        return xParts >= 3 || yParts >= 3;
    }

    private int mergeIntervals(List<int[]> intervals) {
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (!merged.isEmpty() && merged.get(merged.size() - 1)[1] > interval[0]) {
                int[] last = merged.remove(merged.size() - 1);
                merged.add(new int[] {last[0], Math.max(last[1], interval[1])});
            } else {
                merged.add(interval);
            }
        }
        return merged.size();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {1, 0, 5, 2},
                {0, 2, 2, 4},
                {3, 2, 5, 3},
                {0, 4, 4, 5}
        };


        System.out.println(solution.checkValidCuts(5, arr));

    }
}