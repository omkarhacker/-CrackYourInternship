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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<q.val){
            return findAnsistor(root,p,q);
        }
        else{
            return findAnsistor(root,q,p);
        }
    }
    public TreeNode findAnsistor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return null;
        }
        if(root.val>=p.val && root.val<=q.val){
            return root;
        }
        if(root.val<p.val){
            return findAnsistor(root.right,p,q);
        }
        else{
            return findAnsistor(root.left,p,q);
        }
    }
}