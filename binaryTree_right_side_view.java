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
    class Matching{
        TreeNode node;
        int level;
        Matching(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer>ans=new ArrayList<>();
       Queue<Matching>qu=new LinkedList<>();
       HashMap<Integer,TreeNode>hm=new HashMap<>();
       if(root==null){
        return ans;
       }
       qu.add(new Matching(root,0));
       while(!qu.isEmpty()){
         int val=qu.size();
         for(int i=0;i<val;i++){
            Matching node=qu.remove();
            hm.put(node.level,node.node);
            if(node.node.left!=null){
                qu.add(new Matching(node.node.left,node.level+1));
            }
            if(node.node.right!=null){
                qu.add(new Matching(node.node.right,node.level+1));
            }
         }
       }
       Set<Integer>set=hm.keySet();
       for(Integer it:set){
         ans.add(hm.get(it).val);
       }
       return ans;
    }
}