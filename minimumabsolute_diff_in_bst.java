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
    public int getMinimumDifference(TreeNode root) {
        int ans[]=new int[1];
        ans[0]=Integer.MAX_VALUE;
        int pre[]=new int[1];
        pre[0]=-1;
        findDist(root,pre,ans);
        return ans[0];
    }
    public void findDist(TreeNode root,int pre[],int ans[]){
       if(root==null){
        return;
       }
       findDist(root.left,pre,ans);
       if(pre[0]!=-1){
           ans[0]=Math.min(ans[0],Math.abs(root.val-pre[0]));
       }
       pre[0]=root.val;
       findDist(root.right,pre,ans);
    }
}