class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(isTrue(adj,i,-1,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isTrue(ArrayList<ArrayList<Integer>>adj,int i,int parent,boolean visited[]){
        visited[i]=true;
        for(int k=0;k<adj.get(i).size();k++){
            int val=adj.get(i).get(k);
            if(visited[val] && val!=parent){
                return true;
            }
            else if(visited[val] && val==parent){
                continue;
            }
            else{
                return isTrue(adj,val,i,visited);
            }
        }
        return false;
    }
}