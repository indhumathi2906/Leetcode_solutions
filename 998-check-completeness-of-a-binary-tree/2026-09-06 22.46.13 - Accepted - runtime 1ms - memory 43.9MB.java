/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Define the Solution class
class Solution {
  
  // Define the isCompleteTree function that takes a TreeNode as input and returns a boolean
  public boolean isCompleteTree(TreeNode root) {
    // Check if the root node is null, if so, return true (an empty tree is complete)
    if (root == null)
      return true;

    // Create a queue to store the nodes of the tree in level order
    Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));

    while (q.peek() != null) {
   
      TreeNode node = q.poll();

      q.offer(node.left);
      q.offer(node.right);
    }

  
    while (!q.isEmpty() && q.peek() == null)
      q.poll();

    return q.isEmpty();
  }
}