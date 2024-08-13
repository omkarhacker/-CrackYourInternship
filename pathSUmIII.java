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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        return pathSum(root.left,targetSum)+findAns(root,targetSum)+pathSum(root.right,targetSum);
    }
    public int findAns(TreeNode root,long targetSum){
        if(root==null){
            return 0;
        }
        int count=0;
        if(root.val==targetSum){
            count++;
        }
        count=count+findAns(root.left,targetSum-root.val);
        count=count+findAns(root.right,targetSum-root.val);
        return count;
    }
}