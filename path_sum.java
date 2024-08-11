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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return isTrue(root,targetSum,0);
    }
    public boolean isTrue(TreeNode root,int target,int sum){
        if(root.left==null && root.right==null){
            if(sum+root.val==target){
                return true;
            }
            return false;
        }
        boolean first=false;
        if(root.left!=null){
            first=isTrue(root.left,target,sum+root.val);
        }
        boolean second=false;
        if(root.right!=null){
           second=isTrue(root.right,target,sum+root.val);
        }
        return first||second;
    }
}