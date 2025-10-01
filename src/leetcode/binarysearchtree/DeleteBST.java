package leetcode.binarysearchtree;

public class DeleteBST {

    public TreeNode minValNode(TreeNode root) {
        TreeNode curr = root;
        while (curr != null && curr.left!= null) {
            curr = curr.left;
        }
        return curr;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            else {
               TreeNode minNode = minValNode(root.right);
               root.val = minNode.val;
               root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }
    
}