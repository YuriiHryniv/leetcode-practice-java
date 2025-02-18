package smallest_number_from_di_string;

import java.util.*;

class Solution {

    public String smallestNumber(String pattern) {
        int number = pattern.length() + 1;
        String allNumbers = "123456789";
        pattern = pattern + "I";
        allNumbers = allNumbers.substring(0, number);

        int currentSign = 0;
        PriorityQueue<String> pq = new PriorityQueue<String>((first, second) -> Integer.compare(Integer.parseInt(first), Integer.parseInt(second)));
        dfs(allNumbers, "", currentSign, pattern, pq);

        return pq.poll();
    }

    private static void dfs(String allNumbers, String res, int currentSign, String pattern, PriorityQueue<String> pq) {
        if (res.length() == pattern.length()) {
            pq.offer(res);
            return;
        }
        for (int i = 0; i < allNumbers.length(); i++) {

            char currentElement = allNumbers.charAt(i);

            if (currentSign != 0 && pattern.charAt(currentSign - 1) == 'I') {
                if (!res.isEmpty() && Character.getNumericValue(res.charAt(res.length() - 1)) > Character.getNumericValue(currentElement)) {
                    return;
                }
            }

            if (currentSign != 0 && pattern.charAt(currentSign - 1) == 'D') {
                if (!res.isEmpty() && Character.getNumericValue(res.charAt(res.length() - 1)) < Character.getNumericValue(currentElement)) {
                    return;
                }
            }

            String left = allNumbers.substring(0, i);
            String right = allNumbers.substring(i + 1);

            dfs(left + right, res + currentElement, ++currentSign, pattern, pq);

            --currentSign;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestNumber("IIIDIDDD"));
        System.out.println();
    }
}