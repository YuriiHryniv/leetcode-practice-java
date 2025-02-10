package clear_digits;

import java.util.Stack;

class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(String.valueOf(s.charAt(i)));
            if (Character.isDigit(s.charAt(i))) {
                pop(stack);
            }
        }
        int l = stack.size();
        for (int i = 0; i < l; i++) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private void pop(Stack<String> stack) {
        if (!stack.isEmpty()) {
            stack.pop();
        }
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.clearDigits("abc"));

    }
}