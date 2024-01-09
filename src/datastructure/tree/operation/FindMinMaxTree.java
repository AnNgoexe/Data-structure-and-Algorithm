package datastructure.tree.operation;

import datastructure.tree.setting.TreeNode;

public class FindMinMaxTree {
    private TreeNode root;

    public int findMax(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);

        return Math.max(node.data, Math.max(leftMax, rightMax));
    }

    public int findMin(TreeNode node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = findMin(node.left);
        int rightMin = findMin(node.right);

        return Math.min(node.data, Math.min(leftMin, rightMin));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        FindMinMaxTree findMinMaxTree = new FindMinMaxTree();

        int max = findMinMaxTree.findMax(root);
        System.out.println("Max value: " + max);

        int min = findMinMaxTree.findMin(root);
        System.out.println("Min value: " + min);
    }
}
