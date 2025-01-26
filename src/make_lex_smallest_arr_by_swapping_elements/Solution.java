package make_lex_smallest_arr_by_swapping_elements;

import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Set<Integer> usedNumbers = new HashSet<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < sorted.length; j++) {
                Integer last = null;
                if (!list.isEmpty()) {
                    last = list.getLast();
                }
                if (last == null && Math.abs(nums[i] - sorted[j]) <= limit) {
                    list.add(nums[j]);
                } else if (last != null && Math.abs(nums[last] - sorted[j]) <= limit) {
                    list.add(j);
                }
            }
            map.put(i, list);
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> sortedIndexes = map.get(i);
            Integer minIndex = getMin(sortedIndexes, sorted, usedNumbers);
            nums[i] = sorted[minIndex];
            usedNumbers.add(minIndex);
        }

        return nums;
    }

    private Integer getMin(List<Integer> list, int[] sorted, Set<Integer> usedNumbers) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (Integer element: list) {
            if (sorted[element] < min && !usedNumbers.contains(element)) {
                min = sorted[element];
                index = element;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.lexicographicallySmallestArray(new int[]{1,60,34,84,62,56,39,76,49,38}, 4)));
    }
}