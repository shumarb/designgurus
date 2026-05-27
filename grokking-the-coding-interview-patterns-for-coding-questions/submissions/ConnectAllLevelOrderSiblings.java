// Question: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-1-connect-all-level-order-siblings-medium

import java.util.*;

/*class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode next;

  TreeNode(int x) {
    val = x;
    left = right = next = null;
  }
};*/

class ConnectAllLevelOrderSiblings {
    public TreeNode connect(TreeNode root) {
        List<List<TreeNode>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isTest = false;
        int level = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> nodesInLevel = new ArrayList<>();
            int size = queue.size();

            while (size-- > 0) {
                TreeNode top = queue.poll();
                nodesInLevel.add(top);
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
            if (isTest) {
                System.out.print(" * level " + level + ": ");
                for (TreeNode e: nodesInLevel) {
                    System.out.print(e.val + " ");
                }
                System.out.println();
            }
            for (int i = 0; i < nodesInLevel.size() - 1; i++) {
                nodesInLevel.get(i).next = nodesInLevel.get(i + 1);
            }
            list.add(nodesInLevel);
            level++;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            List<TreeNode> currentLevel = list.get(i);
            TreeNode last = currentLevel.get(currentLevel.size() - 1);
            last.next = list.get(i + 1).get(0);
        }
        List<TreeNode> lastLevel = list.get(list.size() - 1);
        lastLevel.get(lastLevel.size() - 1).next = null;
        if (isTest) {
            TreeNode current = root;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            System.out.println();
        }

        return root;
    }
}
