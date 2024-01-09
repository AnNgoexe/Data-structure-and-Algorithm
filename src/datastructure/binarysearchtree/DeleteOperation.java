package datastructure.binarysearchtree;

import datastructure.tree.setting.TreeNode;

import java.util.Scanner;

public class DeleteOperation {
    TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) {
            root.left = this.deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = this.deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null){
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    public int minValue(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public static void main(String[] args) {
        int[] numbers = {20, 18, 3, 15, 1, 2, 10, 8, 9, 7, 6, 0, 23, 4, 5};
        System.out.println("The original array:");

        InsertOperation binarySearchTree = new InsertOperation();
        binarySearchTree.buildBST(numbers);
        TreeNode treeNode = binarySearchTree.getTreeNode();

        System.out.print("\nEnter the number you want to delete: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        DeleteOperation deleteOperation = new DeleteOperation();
        treeNode = deleteOperation.deleteNode(treeNode, num);
        binarySearchTree.inOrderTraversal(treeNode);
    }
}
