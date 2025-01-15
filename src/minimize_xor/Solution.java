package minimize_xor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimizeXor(int num1, int num2) {
        StringBuilder sb = new StringBuilder();

        int num1Count = Integer.bitCount(num1);
        int num2Count = Integer.bitCount(num2);

        int abs = Math.abs(num1Count - num2Count);
        String binaryString = Integer.toBinaryString(num1);
        sb.repeat("0", 32 - binaryString.length());
        sb.append(binaryString);
        char[] targetString = sb.toString().toCharArray();

        int i = targetString.length - 1;
        if (num2Count > num1Count) {
            while (abs > 0 && i > 0) {
                if (targetString[i] == '0' ) {
                    targetString[i] = '1';
                    abs--;
                }
                i--;
            }
        } else {
            while (abs > 0 && i > 0) {
                if (targetString[i] == '1' ) {
                    targetString[i] = '0';
                    abs--;
                }
                i--;
            }
        }

        return Integer.parseInt(new String(targetString), 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimizeXor(25 ,72));
    }
}