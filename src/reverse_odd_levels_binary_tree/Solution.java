package reverse_odd_levels_binary_tree;

import java.util.*;

class Solution {

    public static class TreeNode {
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

    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        reverseAtOdd(queue, root);
        return root;
    }

    private void reverseAtOdd(Queue<TreeNode> queue, TreeNode root) {
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                list.add(polled);

                if (polled.left != null) {
                    queue.offer(polled.left);
                }
                if (polled.right != null) {
                    queue.offer(polled.right);
                }
            }

            if (level % 2 == 1) {
                int left = 0;
                int right = list.size() - 1;

                while (left < list.size() / 2) {
                    int temp = list.get(left).val;
                    list.get(left).val = list.get(right).val;
                    list.get(right).val = temp;
                    right--;
                    left++;
                }
            }
            level++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseOddLevels(new TreeNode(0, new TreeNode(2, new TreeNode(0, new TreeNode(2, null, null), new TreeNode(2, null, null)), new TreeNode(0, new TreeNode(2, null, null), new TreeNode(2, null, null))),
                new TreeNode(1, new TreeNode(0, new TreeNode(1, null, null), new TreeNode(1, null, null)), new TreeNode(0, new TreeNode(1, null, null), new TreeNode(1, null, null))))));
        System.out.println();
    }
}