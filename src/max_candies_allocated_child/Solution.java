package max_candies_allocated_child;

class Solution {
    public int maximumCandies(int[] candies, long k) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for (int i: candies) {
            max = Math.max(max,i);
        }

        int midpoint = (min + max) / 2;
        int res = 0;

        while (min <= max) {
            midpoint = (min + max) / 2;

            if (canDistribute(k, candies, midpoint)) {
                res = midpoint;
                min = midpoint + 1;
            } else {
                max = midpoint - 1;
            }

        }
        return res;
    }

    private boolean canDistribute(long k, int[] candies, int midpoint) {
        long amount = 0;

        for (int candy : candies) {
            amount += candy / midpoint;
        }

        return amount>=k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumCandies(new int[] {2, 5}, 2));
    }
}