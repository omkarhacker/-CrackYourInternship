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
    public void flatten(TreeNode root) {
        ArrayList<TreeNode>adj=new ArrayList<>();
        if(root==null){
            return;
        }
        findPreorder(root,adj);
        TreeNode node2=adj.get(0);
        TreeNode node=node2;
        for(int i=1;i<adj.size();i++){
            TreeNode node1=adj.get(i);
            node.right=node1;
            node.left=null;
            node=node1;
        }
        root=node2;
    }
    public void findPreorder(TreeNode root,ArrayList<TreeNode>adj){
        if(root==null){
            return;
        }
        adj.add(root);
        findPreorder(root.left,adj);
        findPreorder(root.right,adj);
    }
}