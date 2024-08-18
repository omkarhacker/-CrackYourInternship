class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
       
       ArrayList<Integer>ans=new ArrayList<>();
       Queue<Integer>qu=new LinkedList<>();
       boolean visited[]=new boolean[V];
       ans.add(0);
       qu.add(0);
       visited[0]=true;
       while(!qu.isEmpty()){
           int val=qu.remove();
           for(int i=0;i<adj.get(val).size();i++){
               int val1=adj.get(val).get(i);
               if(!visited[val1]){
                   visited[val1]=true;
                    ans.add(val1);
               qu.add(val1);
               }
           }
       }
       return ans;
    }
}