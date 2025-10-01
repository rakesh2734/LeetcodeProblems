package leetcode.binarysearchtree;

class SearchBST {

    TreeNode root;

    // Constructor
    SearchBST() {
        root = null;
    }

       // A utility function to insert
    // a new node with given key in BST
    public TreeNode insert(TreeNode node, int key) {
        // If the tree is empty, return a new node
        if (node == null) {
            node = new TreeNode(key);
            return node;
        }

        // Otherwise, recursively add down the tree
        if (key < node.val)
            node.left = insert(node.left, key);
        else if (key > node.val)
            node.right = insert(node.right, key);

        // Return the (unchanged) node pointer
        return node;
    }
    
    public TreeNode searchBST(TreeNode root, int val) {
      // If the tree is empty root == null or the value to find is here val == root.val - return root.
  
      // If val < root.val - go to search into the left subtree searchBST(root.left, val).
  
      // If val > root.val - go to search into the right subtree searchBST(root.right, val).
  
      // Return root.
      if (root == null || val == root.val) return root;
  
      return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    // Given Scenario's
    // Input: root = [4,2,7,1,3], val = 2
    // Output: [2,1,3]
    public static void main(String[] args) {
        SearchBST tree = new SearchBST();
        // Inserting nodes
        tree.root = tree.insert(tree.root, 4);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 1);
        tree.insert(tree.root, 3);

        // Key to be found
        int key = 6;

        // Searching in a BST
        if (tree.searchBST(tree.root, key) == null)
            System.out.println(key + " not found");
        else
            System.out.println(key + " found");


    }
}