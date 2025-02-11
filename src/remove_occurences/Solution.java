package remove_occurences;


class Solution {

    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            int partStartIndex = s.indexOf(part);
            s =
                    s.substring(0, partStartIndex) +
                            s.substring(partStartIndex + part.length());
        }
        return s;
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