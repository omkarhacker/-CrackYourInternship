class Solution {
    class Node{
        int val;
        int cost;
        Node(int val,int cost){
            this.val=val;
            this.cost=cost;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<manager.length;i++){
            if(manager[i]!=-1){
                adj.get(manager[i]).add(i);
            }
        }
        int ans=0;
        Queue<Node>qu=new LinkedList<>();
        qu.add(new Node(headID,0));
        while(!qu.isEmpty()){
            int size=qu.size();
            for(int i=0;i<size;i++){
                Node x=qu.remove();
                int val=x.val;
                int cost=x.cost;
                ans=Math.max(cost,ans);
                for(int j=0;j<adj.get(val).size();j++){
                    int val1=adj.get(val).get(j);
                    qu.add(new Node(val1,cost+informTime[val]));
                }
            }
        }
        return ans;
    }
}