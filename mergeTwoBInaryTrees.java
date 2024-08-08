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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return findTree(root1,root2);
    }
    public TreeNode findTree(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return null;
        }
        if(root1!=null && root2==null){
            return root1;
        }
        if(root1==null && root2!=null){
            return root2;
        }
        int sum=root1.val+root2.val;
        TreeNode node=new TreeNode(sum);
        node.left=findTree(root1.left,root2.left);
        node.right=findTree(root1.right,root2.right);
        return node;
    }
}