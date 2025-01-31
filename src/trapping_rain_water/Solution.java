package trapping_rain_water;


class Solution {
    public int trap(int[] height) {
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];

        int maxLeft = 0;
        int maxRight = 0;

        for (int i = 0; i < height.length; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            leftMaxArr[i] = maxLeft;
        }

        for (int i = height.length - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            rightMaxArr[i] = maxRight;
        }

        int trapped = 0;

        for (int i = 0; i < height.length; i++) {
            trapped += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }

        return trapped;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(arr));
    }
}