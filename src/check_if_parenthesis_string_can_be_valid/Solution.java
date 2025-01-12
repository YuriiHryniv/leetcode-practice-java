package check_if_parenthesis_string_can_be_valid;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) return false;

        int leftLow = 0;
        int leftHigh = 0;

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    leftLow++;
                    leftHigh++;
                } else {
                    leftLow--;
                    leftHigh--;
                }
            } else {
                leftHigh++;
                leftLow--;
            }

            if (leftLow < 0) leftLow = 0;
        }

        if (leftHigh < 0) return false;
        int rightLow = 0;
        int rightHigh = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') {
                    rightLow++;
                    rightHigh++;
                } else {
                    rightLow--;
                    rightHigh--;
                }
            } else {
                rightLow--;
                rightHigh++;
            }
            if (rightLow < 0) rightLow = 0;
        }

        if (rightHigh < 0) return false;

        return rightLow == 0 && leftLow == 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canBeValid("())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(", "100011110110011011010111100111011101111110000101001101001111"));

    }
}