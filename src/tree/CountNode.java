package tree;

public class CountNode {
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    public static void main(String[] args) {
        CountNode countNode = new CountNode();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int nodeCount = countNode.count(root);
        System.out.println("Number of nodes in tree: " + nodeCount);
    }
}
