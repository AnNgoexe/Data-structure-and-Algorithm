package datastructure.tree.operation;

import datastructure.tree.setting.TreeNode;

public class NodeSum {
    public int calculateSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.data + calculateSum(node.left) + calculateSum(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        NodeSum nodeSum = new NodeSum();
        int sum = nodeSum.calculateSum(root);
        System.out.println("Sum of all nodes in the datastructure.tree: " + sum);
    }
}
