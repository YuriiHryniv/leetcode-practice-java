package find_unique_binary_str;

import java.util.*;

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int l = nums.length;
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(nums));
        return dfs( "", set, l);
    }

    private String dfs(String res, Set<String> set, int l) {
        if (res.length() > l) {
            return null;
        }
        if (res.length() == l && !set.contains(res)) {
            return res;
        }

        for (char i : new char[]{'0', '1'}) {

            String localRes = dfs(res + i, set, l);

            if (localRes != null) return localRes;
        }

        return null;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDifferentBinaryString(new String[]{"111","011","001"}));
    }
}