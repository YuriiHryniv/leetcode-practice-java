package max_count_of_pos_neg_integers;

class Solution {
    public int maximumCount(int[] nums) {
        int pLeft = 0;
        int pRight = nums.length - 1;

        int nLeft = 0;
        int nRight = nums.length - 1;

        while (pLeft <= pRight) {
            int pMidpoint = (pLeft + pRight) / 2;
            int nMidpoint = (nLeft + nRight) / 2;

            if (nums[pMidpoint] <= 0) {
                pLeft = pMidpoint + 1;
            } else {
                pRight = pMidpoint - 1;
            }

            if (nums[nMidpoint] >= 0) {
                nRight = nMidpoint - 1;
            } else {
                nLeft = nMidpoint + 1;
            }
        }

        return Math.max(nums.length - pLeft, nRight + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumCount(new int[] {5,20,66,1314}));
    }
}