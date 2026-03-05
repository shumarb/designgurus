// Question: https://www.designgurus.io/course-play/grokking-recursion/doc/18-split-bst

/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}*/

public class SplitBST {
    public static TreeNode[] splitBST(TreeNode treeRoot, int target) {
        List<TreeNode> first = new ArrayList<>();
        List<TreeNode> second = new ArrayList<>();
        TreeNode[] treeList = new TreeNode[] {null, null};
        boolean isTest = false;

        inOrderTraversal(treeRoot, target, first, second);
        if (isTest) {
            display("first: ", first);
            display("second: ", second);
        }

        treeList[0] = populate(first, 0, first.size() - 1);
        treeList[1] = populate(second, 0, second.size() - 1);

        return treeList;
    }

    private static TreeNode populate(List<TreeNode> list, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = list.get(mid);
        root.left = populate(list, left, mid - 1);
        root.right = populate(list, mid + 1, right);

        return root;
    }

    private static void inOrderTraversal(TreeNode node, int target, List<TreeNode> first, List<TreeNode> second) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, target, first, second);
        if (node.val <= target) {
            first.add(node);
        } else {
            second.add(node);
        }
        inOrderTraversal(node.right, target, first, second);
    }

    private static void display(String s, List<TreeNode> list) {
        System.out.print(s);
        for (TreeNode node: list) {
            System.out.print(node.val + " ");
        }
        System.out.println("\n-------------------------------------------");
    }
}
