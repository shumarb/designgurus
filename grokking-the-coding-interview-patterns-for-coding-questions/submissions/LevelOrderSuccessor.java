// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/level-order-successor-easy

import java.util.*;

/*class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};*/

class LevelOrderSuccessor {
    public TreeNode findSuccessor(TreeNode root, int key) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isKeyFound = false;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode top = queue.poll();
                if (isKeyFound) {
                    return top;
                }
                if (top.val == key) {
                    isKeyFound = true;
                }

                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
        }

        return root;
    }

}
