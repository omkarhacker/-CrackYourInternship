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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode>qu=new LinkedList<>();
        qu.add(root);
        boolean istrue=true;
        while(!qu.isEmpty()){
            int val=qu.size();
            List<Integer>ans=new ArrayList<>();
            for(int i=0;i<val;i++){
                TreeNode node=qu.remove();
                if(!istrue){
                   ans.add(0,node.val);
                }
                else{
                    ans.add(node.val);
                }
                if(node.left!=null){
                    qu.add(node.left);
                }
                if(node.right!=null){
                    qu.add(node.right);
                }
            }
            list.add(ans);
            istrue=!istrue;
        }
        return list;
    }
}