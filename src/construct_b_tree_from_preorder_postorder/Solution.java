package construct_b_tree_from_preorder_postorder;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return dfs(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);

    }

    private TreeNode dfs (int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        if (preorder[preStart] == postorder[postEnd]) {

            for (int i = postStart; i < postEnd; i++) {
                if (preorder[preStart + 1] == postorder[i]) {
                    int leftSize = i - postStart + 1;

                    TreeNode root = new TreeNode(preorder[preStart]);

                    root.left = dfs(preorder, postorder, preStart + 1, preStart + leftSize, postStart, i);

                    root.right = dfs(preorder, postorder, preStart + leftSize + 1, preEnd, i + 1, postEnd - 1);

                    return root;


                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.constructFromPrePost(new int[] {1,2,4,5,3,6,7}, new int[] {4,5,2,6,7,3,1}));
    }
}