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
    class Node{
        int val;
        boolean isvalue;
        Node(int val,boolean isvalue){
            this.val=val;
            this.isvalue=isvalue;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return isTrue(root).isvalue;
    }
    public Node isTrue(TreeNode root){
        if(root==null){
            return new Node(0,true);
        }
        Node val1=isTrue(root.left);
        Node val2=isTrue(root.right);
        if(Math.abs(val1.val-val2.val)>1){
            return new Node(Math.max(val1.val,val2.val)+1,false);
        }
        return new Node(Math.max(val1.val,val2.val)+1,val1.isvalue&&val2.isvalue);
    }
}