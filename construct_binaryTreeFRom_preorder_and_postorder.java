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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            hm.put(postorder[i],i);
        }
        return constructTree(preorder,postorder,0,preorder.length-1,0,postorder.length-1,hm);
    }
    public TreeNode constructTree(int preorder[],int postorder[],int start,int end,int prestart,int preend,HashMap<Integer,Integer>hm){
        if(start>end){
            return null;
        }
        TreeNode node=new TreeNode(preorder[start]);
        if(start==end){
            return node;
        }
        int index=hm.get(preorder[start+1]);
        int range=index-prestart+1;
        node.left=constructTree(preorder,postorder,start+1,start+range,prestart,index,hm);
        node.right=constructTree(preorder,postorder,start+range+1,end,index+1,preend,hm);
        return node;
    }
}