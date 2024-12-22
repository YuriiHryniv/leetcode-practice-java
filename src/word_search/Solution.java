package word_search;

import java.util.*;

class Solution {
    public boolean exist(char[][] board, String word) {
        Stack<Character> stringStack = new Stack<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (word.charAt(0) == board[row][column]) {
                    boolean found = findWord(visited, board, word, row, column, stringStack);
                    if (found) {
                        return true;
                    } else {
                        stringStack.clear();
                    }
                }
            }
        }
        return false;

    }

    private boolean findWord(boolean[][] visited, char[][] board, String word, int row, int column, Stack<Character> stringStack) {
        char found = board[row][column];
        visited[row][column] = true;

        if (stringStack.size() >= word.length()) {
            return false;
        }

        boolean first = false;
        boolean second = false;
        boolean third = false;
        boolean fourth = false;

        if (found == word.charAt(stringStack.size())) {
            stringStack.push(found);
        } else {
            visited[row][column] = false;
            return false;
        }

        if (found == word.charAt(word.length() - 1) && stringStack.size() == word.length()) {
            return true;
        }

        if (row - 1 >= 0 && !visited[row - 1][column]) {
            first = findWord(visited, board, word, row - 1, column, stringStack);
        }

        if (row + 1 <= board.length - 1 && !visited[row + 1][column]) {
            second = findWord(visited, board, word, row + 1, column, stringStack);
        }

        if (column - 1 >= 0 && !visited[row][column - 1]) {
            third = findWord(visited, board, word, row, column - 1, stringStack);
        }

        if (column + 1 <= board[0].length - 1 && !visited[row][column + 1]) {
            fourth = findWord(visited, board, word, row, column + 1, stringStack);
        }

        if (!(first || second || third || fourth)) {
            stringStack.remove(stringStack.getLast());
            visited[row][column] = false;
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        Solution solution = new Solution();
        System.out.println(solution.exist(board, "ABCB"));
    }
}