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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean arr[]=new boolean[1];
       
        return  findValue(root,subRoot,arr);
    }
    public boolean findValue(TreeNode root,TreeNode subRoot,boolean arr[]){
           if(root==null){
            return false;
           }
           if(root.val==subRoot.val && isPossible(root,subRoot)){
              return true;
           }
           return findValue(root.left,subRoot,arr)||findValue(root.right,subRoot,arr);
    }
    public boolean isPossible(TreeNode root,TreeNode subRoot){
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null || subRoot==null){
            return false;
        }
        if(root.val!=subRoot.val){
            return false;
        }
        return isPossible(root.left,subRoot.left) && isPossible(root.right,subRoot.right);
    }
}