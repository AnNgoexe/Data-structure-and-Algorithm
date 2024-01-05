package tree;

public class MirrorTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 != null && t2 != null && t1.data == t2.data) {
            return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(3);

        MirrorTree mirrorTree = new MirrorTree();
        boolean result = mirrorTree.isSymmetric(tree);
        System.out.println("Is the tree symmetric? " + result);
    }
}
