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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>li=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        findPath(li,root,str);
        return li;
    }
    public void findPath(List<String>li,TreeNode root,StringBuilder str){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            int len=str.length();
            str.append(root.val);
            li.add(str.toString());
            str.setLength(len);
            return;
        }
        int len=str.length();
        str.append(root.val+"->");
        if(root.left!=null){
           findPath(li,root.left,str);
        }
        if(root.right!=null){
           findPath(li,root.right,str);
        }
        str.setLength(len);
    }
}