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


class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs((heights(root.left) - heights(root.right))) > 1){
            return false;
        }
        //check to see if left and right are balacned oto
        return isBalanced(root.left) && isBalanced(root.right);
    }


    public int heights(TreeNode root){
        if(root == null){
            return 1;
        }
        //gives u max depth of left and right

        return Math.max(heights(root.left) + 1, heights(root.right) + 1);
    }



}
