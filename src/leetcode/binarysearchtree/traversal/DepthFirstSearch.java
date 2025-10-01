package leetcode.binarysearchtree.traversal;

import leetcode.binarysearchtree.TreeNode;

public class DepthFirstSearch {

    // InOrder Traversal
    // The tree traversal will go from (left-child->parent node->right-child)
    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    // Pre Order Traversal
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // Post-Order Traversal
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    // To Test need to intialize using the unit tests or using the main method
    // Will test this using the main method by initializing the value

}