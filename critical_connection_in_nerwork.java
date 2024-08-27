class Solution {
    private int timer=1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
          for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
          }
          int m=connections.size();
          for(int i=0;i<m;i++ ){
             int val1=connections.get(i).get(0);
             int val2=connections.get(i).get(1);
             adj.get(val1).add(val2);
             adj.get(val2).add(val1);
          }
          int vis[]=new int[n];
          int tin[]=new int[n];
          int low[]=new int[n];
          List<List<Integer>>ans=new ArrayList<>();
          dfs(0,-1,vis,adj,tin,low,ans);
       return ans;
    }
    public void dfs(int node,int parent,int vis[],ArrayList<ArrayList<Integer>>adj,int tin[],int low[],List<List<Integer>>bridge){
          vis[node]=1;
          tin[node]=low[node]=timer;
          timer++;
          for(Integer it:adj.get(node)){
            if(it==parent){
                continue;
            }
            if(vis[it]==0){
                dfs(it,node,vis,adj,tin,low,bridge);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>tin[node]){
                    bridge.add(Arrays.asList(it,node));
                }
            }
            else{
                low[node]=Math.min(low[node],low[it]);
            }
          }
    }
}