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
        return findAnsestor(root,p,q);
    }
    public TreeNode findAnsestor(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return null;
        }
         if(root.val==p.val){
            return root;
        }
        if(root.val==q.val){
            return root;
        }
        TreeNode left=findAnsestor(root.left,p,q);
        TreeNode right=findAnsestor(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        return right;
    }
}