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
    public TreeNode invertTree(TreeNode root) {
        return reverseTree(root);
    }
    public TreeNode reverseTree(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode left=reverseTree(root.left);
        TreeNode right=reverseTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
}