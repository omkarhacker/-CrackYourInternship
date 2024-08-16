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
    public int kthSmallest(TreeNode root, int k) {
        
        int ans[]=new int[1];
        int val[]=new int[1];
        val[0]=k;
        findAns(root,val,ans);
        return ans[0];
    }
    public void findAns(TreeNode root,int val[],int ans[]){
        if(root==null){
            return;
        }
        findAns(root.left,val,ans);
        val[0]--;
        if(val[0]==0){
            ans[0]=root.val;
        }
        findAns(root.right,val,ans);
    }
}