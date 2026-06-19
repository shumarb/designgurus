// Question: https://www.designgurus.io/course-play/grokking-data-structures-for-coding-interviews/doc/closest-binary-search-tree-value-medium

// Define a TreeNode structure with left and right children.
// class TreeNode {
//     int val;                  // Value stored in the node.
//     TreeNode left;            // Reference to the left child.
//     TreeNode right;           // Reference to the right child.

//     // Constructor to initialize a new node with a value.
//     TreeNode(int x) {
//         val = x;
//     }
// }

public class ClosestBinarySearchTreeValue {
    private TreeNode closestNode = null;
    private double minimumDifference = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        closestNode = root;
        traverse(root, target);
        return closestNode.val;
    }

    private void traverse(TreeNode node, double target) {
        if (node == null) {
            return;
        }

        double currentDifference = Math.abs((double) node.val - target);
        if ((currentDifference < minimumDifference) || currentDifference == minimumDifference && node.val < closestNode.val) {
            closestNode = node;
            minimumDifference = currentDifference;
        }

        if (target < node.val) {
            traverse(node.left, target);
        }
        traverse(node.right, target);
    }
}
