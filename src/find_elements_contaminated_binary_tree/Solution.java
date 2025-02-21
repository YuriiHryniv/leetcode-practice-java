package find_elements_contaminated_binary_tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class FindElements {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    HashSet<Integer> set;

    public FindElements(TreeNode root) {
        set = new HashSet<>();
        root.val = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int l = queue.size();
            for (int i = 0; i < l; i++) {
                TreeNode element = queue.poll();

                if (element.left != null) {
                    element.left.val = 2 * element.val + 1;
                    queue.add(element.left);
                    set.add(element.left.val);
                }

                if (element.right != null) {
                    element.right.val = 2 * element.val + 2;
                    queue.add(element.right);
                    set.add(element.right.val);
                }
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    public static void main(String[] args) {


        FindElements findElements = new FindElements(new TreeNode(-1,
                new TreeNode(-1, new TreeNode(-1, null, null), new TreeNode(-1, null, null)),
                new TreeNode(-1, null, null)));


        System.out.println(findElements.find(1));
        System.out.println(findElements.find(2));
        System.out.println(findElements.find(2));
        System.out.println(findElements.find(2));

    }
}