package remove_occurences;


class Solution {

    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            String element = String.valueOf(s.charAt(i));
            sb.append(element);
            if (sb.toString().endsWith(part)) {
                sb.delete(sb.length() - part.length(), sb.length());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5}
        };
        int[][] arr1 = {
                {1, 2},
                {1, 3},
                {2, 3}
        };


        System.out.println((solution.removeOccurrences("axxxxyyyyb", "xy")));
    }
}