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
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer>adj=new ArrayList<>();
       findInorder(root,adj);
       return adj;
    }
    public void findInorder(TreeNode root,List<Integer>adj){
        if(root==null){
            return;
        }
        findInorder(root.left,adj);
        adj.add(root.val);
        findInorder(root.right,adj);
    }
}