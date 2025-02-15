package punishment_number_of_integer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int punishmentNumber(int n) {
        int currentP = 0;

        for (int i = 0; i <= n; i++) {

            int square = i * i;

            if (isPartitioned(square)) {
                currentP += square;
            }
        }

        return currentP;
    }

    private boolean isPartitioned(int n) {
        String number = String.valueOf(n);
        List<List<String>> partitions = getPartitions(number);
        for (List<String> partition : partitions) {
            int sum = 0;
            for (String s : partition) {
                sum += Integer.parseInt(s);
            }
            if (sum == Math.sqrt(n)) {
                return true;
            }
        }
        return false;
    }

    private List<List<String>> getPartitions(String number) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (number.isEmpty()) {
            return Collections.singletonList(new ArrayList<>());
        }

        for (int i = 0; i < number.length(); i++) {
            String substring = number.substring(0, i + 1);

            List<List<String>> partitions = getPartitions(number.substring(i + 1));
            for (List<String> partition : partitions) {
                partition.addFirst(substring);
            }
            res.addAll(partitions);

        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.punishmentNumber(37));
        System.out.println();
    }
}