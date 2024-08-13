/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        HashMap<TreeNode,TreeNode>hm=new HashMap<>();
        findParent(hm,root);
        List<Integer>ans=new ArrayList<>();
        Set<TreeNode>set=hm.keySet();
        for(TreeNode x:set){
            System.out.println(x.val);
            System.out.println(hm.get(x).val);
        }
        findAns(target,k,ans,hm);
        return ans;
    }
    public void findParent(HashMap<TreeNode,TreeNode>hm,TreeNode root){
        if(root==null){
            return ;
        }
        if(root.left!=null){
            hm.put(root.left,root);
        }
        if(root.right!=null){
            hm.put(root.right,root);
        }
        findParent(hm,root.left);
        findParent(hm,root.right);
    }
    public void findAns(TreeNode target,int k,List<Integer>li,HashMap<TreeNode,TreeNode>hm){
        Queue<TreeNode>qu=new LinkedList<>();
        HashMap<TreeNode,Boolean>visited=new HashMap<>();
        qu.add(target);
        visited.put(target,true);
        int count=0;
        while(!qu.isEmpty()){
            int size=qu.size();
            if(count==k){
                break;
            }
            count++;
            for(int i=0;i<size;i++){
                TreeNode node=qu.remove();
                if(node.left!=null && visited.get(node.left)==null){
                    qu.add(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    qu.add(node.right);
                    visited.put(node.right,true);
                }
                if(hm.get(node)!=null && visited.get(hm.get(node))==null){
                    qu.add(hm.get(node));
                    visited.put(hm.get(node),true);
                }
            }
        }
        while(!qu.isEmpty()){
            TreeNode node=qu.remove();
            li.add(node.val);
        }
    }
}