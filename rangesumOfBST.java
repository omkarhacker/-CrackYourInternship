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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return findSum(root,low,high);
    }
    public int findSum(TreeNode root,int low,int high){
        if(root==null){
            return 0;
        }
        if(root.val>=low && root.val<=high){
            return root.val+findSum(root.left,low,high)+findSum(root.right,low,high);
        }
        else if(high<root.val){
            return findSum(root.left,low,high);
        }
        else{
            return findSum(root.right,low,high);
        }
    }
}