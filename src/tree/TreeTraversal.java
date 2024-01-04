package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            System.out.print(tmp.data + " ");
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeTraversal treeTraversal = new TreeTraversal();

        System.out.println("Preorder Traversal:");
        treeTraversal.preOrder(root);

        System.out.println("\nInorder Traversal:");
        treeTraversal.inOrder(root);

        System.out.println("\nPostorder Traversal:");
        treeTraversal.postOrder(root);

        System.out.println("\nLevel Order Traversal:");
        treeTraversal.levelOrder(root);
    }
}
