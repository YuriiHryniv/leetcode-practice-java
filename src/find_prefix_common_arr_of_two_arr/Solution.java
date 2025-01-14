package find_prefix_common_arr_of_two_arr;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int commonCount = 0;
        int [] C = new int[A.length];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            boolean isAAdded = set.add(A[i]);
            boolean isBAdded = set.add(B[i]);

            if (!isAAdded) commonCount++;
            if (!isBAdded) commonCount++;

            C[i] = commonCount;
        }
        return C;
    }
}