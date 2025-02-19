package k_th_lexicographical_str_of_happy_strings;

import java.util.PriorityQueue;
import java.util.TreeSet;

class Solution {
    public String getHappyString(int n, int k) {
        TreeSet<String> set = new TreeSet<>();

        dfs(n, set, "", "abc", k);

        if (k > set.size()) return "";

        return set.getLast();
    }

    private void dfs(int n, TreeSet<String> set, String res, String target, int k) {
        if (set.size() == k) {
            return;
        }
        if (res.length() == n ) {
            set.add(res);
            return;
        }

        for (int i = 0; i < target.length(); i++) {

            String currentStr = target.charAt(i) + "";

            if (!res.isEmpty() && res.charAt(res.length() - 1) == currentStr.charAt(0)) {
                continue;
            }

            dfs(n, set,res + currentStr, target, k);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getHappyString(3, 9));
    }
}