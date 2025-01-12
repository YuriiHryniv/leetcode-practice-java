package check_if_parenthesis_string_can_be_valid;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean canBeValid(String s, String locked) {
        int length = s.length();

        if (length % 2 == 1) {
            return false;
        }

        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();

        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                openBrackets.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openBrackets.empty()) {
                    openBrackets.pop();
                } else if (!unlocked.empty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }

        while (
                !openBrackets.empty() &&
                        !unlocked.empty() &&
                        openBrackets.peek() < unlocked.peek()
        ) {
            openBrackets.pop();
            unlocked.pop();
        }

        if (!openBrackets.empty()) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canBeValid("))()))", "010100"));

    }
}