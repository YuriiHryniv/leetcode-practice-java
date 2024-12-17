package construct__string_with_repeat_limit;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Set<String> limitedSet = new HashSet<>();
        StringBuilder res = new StringBuilder();
        StringBuilder notAdded = new StringBuilder();
        Queue<String> queue = new PriorityQueue<>((first, second) -> {
            return second.compareTo(first);
        });

        for (int i = 0; i < s.length(); i++) {
            queue.offer(Character.toString(s.charAt(i)));
        }

        int currentRepeatLimit = 0;

        while (!queue.isEmpty()) {
            String letter = queue.poll();
            if (!res.isEmpty() && !Character.toString(res.charAt(res.length() - 1)).equals(letter)) {
                currentRepeatLimit = 0;
            }
            if (currentRepeatLimit >= repeatLimit || limitedSet.contains(letter)) {
                limitedSet.add(letter);
                currentRepeatLimit = 0;
                notAdded.append(letter);
            } else {
                res.append(letter);
                currentRepeatLimit++;
            }
        }
        return res.append(notAdded).toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatLimitedString("aababab", 2));
    }
}