package leetcode.queue;

import java.util.*;

public class BreadthFirstSearch {
    
// Definition for a binary tree node.
    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }

    /**
     * 102. Binary Tree Level Order Traversal
     * */

    // Using the DFS
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }

    /**
     * Return the length of the shortest path between root and target node.
     */
    public class ReturnShortestPathTree {

        class Node {

        }

        int shortestPathBwRootTarget(TreeNode root, TreeNode target ) {
            Queue<TreeNode> queue = new LinkedList<>();
            int steps = 0;

            queue.add(root); // queue.offer(root); offer is nothing but add with return a null if fails


            return 0;
        }
    }
    /**
     * Breadth first search BFS level order traversal
     */
    public static List<List<Integer>> treeLevelOrderTraversalBFS(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        q.offer(root); // Add a value

        while(!q.isEmpty()) {
            int level = q.size();
            List<Integer> temp = new LinkedList<>();
            for(int i=0; i<level ; i++ ) {
                TreeNode curr = q.peek(); // q.element(); return a value but not delete
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
                temp.add(q.poll().val); // poll() will remove the value from the queue
            }
            res.add(temp);
        }

        return res;
    }

    public static void main(String[] args) {

        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());

        TreeNode node = new TreeNode(5);
        treeLevelOrderTraversalBFS(node);
    }


}
