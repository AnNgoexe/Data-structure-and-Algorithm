package datastructure.tree.operation;

import datastructure.tree.setting.TreeNode;

public class TreeHeight {
    public int findMaxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = findMaxHeight(root.left);
        int rightHeight = findMaxHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int findMinHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = findMinHeight(root.left);
        int rightHeight = findMinHeight(root.right);
        return Math.min(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeHeight treeHeight = new TreeHeight();
        int maxHeight = treeHeight.findMaxHeight(root);
        int minHeight = treeHeight.findMinHeight(root);
        System.out.println("Max height of the datastructure.tree: " + maxHeight);
        System.out.println("Min height of the datastructure.tree: " + minHeight);
    }
}
