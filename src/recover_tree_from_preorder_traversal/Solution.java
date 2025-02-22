package recover_tree_from_preorder_traversal;

import com.sun.source.tree.Tree;

import java.util.*;

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode recoverFromPreorder(String traversal) {
        int level = 0;
        TreeNode root = null;
        Stack<TreeNode> stackNum = new Stack<>();
        Stack<Integer> stackLevel = new Stack<>();
        int i = 0;

        while (i < traversal.length()) {
            if (Character.isDigit(traversal.charAt(i))) {

                int j = i;

                while (j < traversal.length() && Character.isDigit(traversal.charAt(j))) {
                    j++;
                }
                int number = Integer.parseInt(traversal.substring(i, j));

                if (root == null) {
                    root = new TreeNode(number);
                    stackLevel.push(level);
                    stackNum.push(root);
                } else {
                    while (level <= stackLevel.peek()) {
                        stackNum.pop();
                        stackLevel.pop();
                    }

                    TreeNode peeked = stackNum.peek();
                    TreeNode inserted = new TreeNode(number);
                    if (peeked.left == null) {
                        peeked.left = inserted;
                        stackNum.push(inserted);
                        stackLevel.push(level);

                    } else if (peeked.right == null) {
                        peeked.right = inserted;
                        stackNum.push(inserted);
                        stackLevel.push(level);
                    }
                }

                level = 0;
                i = j;
            } else {
                level++;
                i++;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.recoverFromPreorder("3-2--3---10---7-2--9"));
    }
}