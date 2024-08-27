class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        
        int visited[]=new int[V];
        Arrays.fill(visited,-1);
        for(int i=0;i<V;i++){
            if(visited[i]==-1){
                if(!isTrue(i,visited,adj,0)){
                   return false;
                }
            }
        }
        return true;
    }
    public boolean isTrue(int i,int visited[],ArrayList<ArrayList<Integer>>adj,int j){
        visited[i]=j;
        for(int k=0;k<adj.get(i).size();k++){
            int val=adj.get(i).get(k);
            if(visited[val]==visited[i]){
                return false;
            }
            else if(visited[val]==-1){
                if(j==0){
                    if(!isTrue(val,visited,adj,1)){
                       return false;
                    }
                }
                else{
                    if(!isTrue(val,visited,adj,0)){
                       return false;
                    }
                }
                
            }
        }
        return true;
    }
}