package design_number_container_system;

import java.util.*;

class Solution {
    class NumberContainers {
        Map<Integer, Integer> indexValueMap;
        Map<Integer, TreeSet<Integer>> valueIndexMap;

        public NumberContainers() {
            indexValueMap = new HashMap<>();
            valueIndexMap = new HashMap<>();
        }

        public void change(int index, int number) {
            TreeSet<Integer> treeSet = valueIndexMap.get(number);
            if (treeSet == null) {
                treeSet = new TreeSet<>();
                treeSet.add(index);
                valueIndexMap.put(number, treeSet);
            } else {
                treeSet.add(index);
            }

            Integer valueByIndex = indexValueMap.get(index);
            TreeSet<Integer> treeSet1 = valueIndexMap.get(valueByIndex);

            if (valueByIndex != null && number != valueByIndex) {
                treeSet1.remove(index);
            }

            indexValueMap.put(index, number);

        }

        public int find(int number) {
            TreeSet<Integer> treeSet = valueIndexMap.get(number);
            if (treeSet == null || treeSet.isEmpty()) return -1;
            return treeSet.getFirst();
        }
    }

    public static void main(String[] args) {
        Solution.NumberContainers sol = new Solution().new NumberContainers();
        sol.find(10);
        sol.change(2,10);
        sol.change(1,10);
        sol.change(3,10);
        sol.change(5,10);
        sol.find(10);
        sol.change(1,20);
        sol.find(10);

        /*sol.change(1,10);
        sol.change(1,10);
        System.out.println(sol.find(10));
        sol.change(1,20);
        System.out.println(sol.find(10));*/


    }
}