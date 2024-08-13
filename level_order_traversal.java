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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>adj=new ArrayList<>();
        if(root==null){
            return adj;
        }
        HashMap<Integer,List<Integer>>hm=new HashMap<>();
        Queue<TreeNode>qu=new LinkedList<>();
        qu.add(root);
        int count=0;
        while(!qu.isEmpty()){
            int val=qu.size();
            count++;
            for(int i=0;i<val;i++){
                TreeNode node=qu.remove();
                if(hm.containsKey(count)){
                    List<Integer>li=hm.get(count);
                    li.add(node.val);
                    hm.put(count,li);
                }
                else{
                    List<Integer>li=new ArrayList<>();
                    li.add(node.val);
                    hm.put(count,li);
                }
                if(node.left!=null){
                    qu.add(node.left);
                }
                if(node.right!=null){
                    qu.add(node.right);
                }
            }
        }
        Set<Integer>set=hm.keySet();
        for(Integer it:set){
            adj.add(hm.get(it));
        }
        return adj;
    }
}