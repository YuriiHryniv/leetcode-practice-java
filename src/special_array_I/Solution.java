package special_array_I;

class Solution {

    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;

        boolean[] res = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] % 2 == 0;
        }

        int first = 0;
        int second = 1;

        boolean fParity = res[first];
        boolean sParity = res[second];

        if (fParity == sParity) return false;

        for (int i = 0; i < nums.length; i += 2) {
            if (fParity != res[i]) return false;
        }

        for (int i = 1; i < nums.length; i += 2) {
            if (sParity != res[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isArraySpecial(new int[]{1,2,3}));
    }
}