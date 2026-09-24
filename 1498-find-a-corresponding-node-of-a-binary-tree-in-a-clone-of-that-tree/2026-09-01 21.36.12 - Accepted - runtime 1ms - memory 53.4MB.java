/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if(original == target){
            return cloned;
        }

        if(original.left != null){
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if(left != null) return left;
        }

        if(original.right != null){
            return getTargetCopy(original.right, cloned.right, target);
        }

        return null;
    }
}

 