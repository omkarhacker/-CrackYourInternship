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
    int count=0;
    public int minCameraCover(TreeNode root) {
       int val= findVal(root);
      if(val==-1){
        return count+1;
      }
        return count;
    }
    public int findVal(TreeNode root){
        if(root==null){
            return 1;
        }
        int left=findVal(root.left);
        int right=findVal(root.right);
        if(left==-1 || right==-1){
            count++;
            return 0;
        }
        if(left==0 || right==0){
            return 1;
        }
        if(left==1 || right==1){
            return -1;
        }
        return 0;
    }
}