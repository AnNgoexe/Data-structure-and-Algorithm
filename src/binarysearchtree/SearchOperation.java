package binarysearchtree;

import tree.TreeNode;

import java.util.Scanner;

public class SearchOperation {
    public int findMin(TreeNode root) {
        if (root == null) {
            return -1;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public int findMax(TreeNode root) {
        if (root == null) {
            return -1;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public boolean search(TreeNode root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if (key > root.data) {
            return this.search(root.right, key);
        } else {
            return this.search(root.left, key);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {20, 18, 3, 15, 1, 2, 10, 8, 9, 7, 6, 0, 23, 4, 5};
        System.out.println("The original array:");

        InsertOperation binarySearchTree = new InsertOperation();
        binarySearchTree.buildBST(numbers);
        TreeNode treeNode = binarySearchTree.getTreeNode();

        System.out.print("\nEnter the number you want to search: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        SearchOperation searchOperation = new SearchOperation();
        System.out.println("Search the number " + num + " :" + searchOperation.search(treeNode, num));
    }
}
