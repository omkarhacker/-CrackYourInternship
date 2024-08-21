class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
       boolean visited[]=new boolean[V];
       boolean pathVisited[]=new boolean[V];
       for(int i=0;i<V;i++){
           if(isTrue(adj,i,visited,pathVisited)){
               return true;
           }
       }
       return false;
    }
    public boolean isTrue(ArrayList<ArrayList<Integer>>adj,int i,boolean visited[],boolean pathVisited[]){
        visited[i]=true;
        pathVisited[i]=true;
        for(int j=0;j<adj.get(i).size();j++){
            int val=adj.get(i).get(j);
            if(!visited[val]){
                if(isTrue(adj,val,visited,pathVisited)){
                    return true;
                }
            }
            else if(visited[val] && pathVisited[val]){
                return true;
            }
        }
        pathVisited[i]=false;
        return false;
    }
}