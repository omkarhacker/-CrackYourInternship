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
    public int sumOfLeftLeaves(TreeNode root) {
        return findSum(root,null);
    }
    public int findSum(TreeNode root,Boolean isTrue){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            if(isTrue!=null && isTrue==true){
                return root.val;
            }
            return 0;
        }
        return findSum(root.left,true)+findSum(root.right,false);
    }
}