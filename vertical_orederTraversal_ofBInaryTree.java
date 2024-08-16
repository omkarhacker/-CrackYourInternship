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
        TreeNode val;
        int dist;
        Node(TreeNode val,int dist){
            this.val=val;
            this.dist=dist;
        }
    }
    class Node1{
        TreeNode node;
        int val1;
        int val2;
        Node1(TreeNode node,int val1,int val2){
            this.node=node;
            this.val1=val1;
            this.val2=val2;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,PriorityQueue<Node1>>tm=new TreeMap<>();
        Queue<Node>qu=new LinkedList<>();
        qu.add(new Node(root,0));
        int val=0;
        while(!qu.isEmpty()){
            int a= qu.size();
            for(int i=0;i<a;i++){
                Node node=qu.remove();
                TreeNode val1=node.val;
                int val2=node.dist;
                if(tm.containsKey(val2)){
                    PriorityQueue pq=tm.get(val2);
                    pq.add(new Node1(val1,val,val2));
                    tm.put(val2,pq);
                }
                else{
                    PriorityQueue<Node1>pq=new PriorityQueue<>((x,y)->{
                        if(x.val1==y.val1){
                            return x.node.val-y.node.val;
                        }
                        else{
                            return x.val1-y.val1;
                        }
                });
                    pq.add(new Node1(val1,val,val2));
                    tm.put(val2,pq);
                }
                if(val1.left!=null){
                    qu.add(new Node(val1.left,val2-1));
                }
                if(val1.right!=null){
                    qu.add(new Node(val1.right,val2+1));
                }
            }
            val++;
        }
        List<List<Integer>>li=new ArrayList<>();
        Set<Integer>set=tm.keySet();
        for(Integer it:set){
            List<Integer>list=new ArrayList<>();
            PriorityQueue<Node1>pq=tm.get(it);
            while(!pq.isEmpty()){
                list.add(pq.remove().node.val);
            }
            li.add(list);
        }
        return li;
    }
}