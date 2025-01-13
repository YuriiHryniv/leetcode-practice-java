package valid_parenthesis_string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> fixedStack = new Stack<>();
        Stack<Integer> unfixedStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                unfixedStack.push(i);
            } else if (s.charAt(i) == '(') {
                fixedStack.push(i);
            } else if (s.charAt(i) == ')' && !fixedStack.empty() && s.charAt(fixedStack.peek()) == '(') {
                fixedStack.pop();
            } else {
                fixedStack.push(i);
            }
        }

        while (!fixedStack.isEmpty() && !unfixedStack.isEmpty()
                && ((s.charAt(fixedStack.peek()) == '(' && unfixedStack.peek() > fixedStack.peek()) || (s.charAt(fixedStack.peek()) == ')' && unfixedStack.peek() < fixedStack.peek()))) {
            fixedStack.pop();
            unfixedStack.pop();

            while (!fixedStack.empty() && unfixedStack.size() > fixedStack.size() && s.charAt(fixedStack.peek()) == ')' && unfixedStack.peek() > fixedStack.peek()) {
                unfixedStack.pop();
            }
        }

        return fixedStack.empty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkValidString("((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()"));
    }
}