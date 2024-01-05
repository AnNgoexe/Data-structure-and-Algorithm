package binarysearchtree;

import java.util.Arrays;
import tree.TreeNode;

public class InsertOperation {
     public TreeNode root;

     public void insert(int number) {
          this.root = this.insertRecursive(this.root, number);
     }

     public TreeNode insertRecursive(TreeNode root, int number) {
          if (root == null) {
              return new TreeNode(number);
          }
          if(number < root.data) {
               root.left = this.insertRecursive(root.left, number);
          } else {
               root.right = this.insertRecursive(root.right, number);
          }
          return root;
     }

     public void inOrderTraversal(TreeNode root) {
          if (root == null) {
               return;
          }
          this.inOrderTraversal(root.left);
          System.out.print(root.data + " ");
          this.inOrderTraversal(root.right);
     }

     public void buildBST(int[] numbers) {
          for (int number : numbers) {
               this.insert(number);
          }
          this.inOrderTraversal(root);
     }

     public TreeNode getTreeNode() {
          return this.root;
     }

     public static void main(String[] args) {
          int[] numbers = {20, 18, 3, 15, 1, 2, 10, 8, 9, 7, 6, 0, 23, 4, 5};
          System.out.println("The original array:");
          System.out.println(Arrays.toString(numbers));
          System.out.println("Inorder traversal for binary search tree:");
          InsertOperation bst = new InsertOperation();
          bst.buildBST(numbers);
     }
}
