package tree;

public class SameTree {
    public boolean isSameTree(TreeNode firstTree, TreeNode secondTree) {
        if (firstTree == null && secondTree == null) {
            return true;
        } else if (firstTree != null && secondTree != null
                && firstTree.data == secondTree.data) {
            return isSameTree(firstTree.left, secondTree.left)
                    && isSameTree(firstTree.right, secondTree.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.left = new TreeNode(6);
        tree1.right.right = new TreeNode(7);

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        tree2.left.left = new TreeNode(4);
        tree2.left.right = new TreeNode(5);
        tree2.right.left = new TreeNode(6);
        tree2.right.right = new TreeNode(7);

        SameTree sameTree = new SameTree();
        boolean result = sameTree.isSameTree(tree1, tree2);
        System.out.println("Are the trees the same? " + result);
    }
}
