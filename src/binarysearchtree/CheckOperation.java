package binarysearchtree;

import tree.TreeNode;

public class CheckOperation {
    public boolean checkDefinition(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        if (root.data <= min || root.data >= max) {
            return false;
        }
        return this.checkDefinition(root.left, min, root.data)
                && this.checkDefinition(root.right, root.data, max);
    }

    public boolean checkUsingDefinition(TreeNode root) {
        return this.checkDefinition(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkInorder(TreeNode node, TreeNode prev) {
        if (node == null) {
            return true;
        }
        if (!checkInorder(node.left, prev)) {
            return false;
        }
        if (prev != null && node.data <= prev.data) {
            return false;
        }
        prev = node;
        return checkInorder(node.right, prev);
    }

    public boolean checkUsingInorderTraversal(TreeNode root) {
        return this.checkInorder(root, null);
    }

    public static void main(String[] args) {
        CheckOperation checkOperation = new CheckOperation();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        //Method 1: using definition.
        System.out.print("Method 1 - Using definition: ");
        System.out.print(checkOperation.checkUsingDefinition(root));

        //Method 2: using inorder traversal.
        System.out.print("\nMethod 2 - Using inorder traversal:");
        System.out.print(checkOperation.checkUsingInorderTraversal(root));
    }
}
