class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer>st=new Stack<>();
        boolean visited1[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited1[i]){
                dfs1(st,i,adj,visited1);
            }
        }
        ArrayList<ArrayList<Integer>>revAdj=new ArrayList<>();
        for(int i=0;i<V;i++){
            revAdj.add(new ArrayList<>());
        }
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                revAdj.get(adj.get(i).get(j)).add(i);
            }
        }
        boolean visited[]=new boolean[V];
        int count=0;
        while(!st.isEmpty()){
            int val=st.pop();
            if(!visited[val]){
                count++;
                dfs(visited,revAdj,val);
            }
        }
        return count;
    }
    public void dfs(boolean visited[],ArrayList<ArrayList<Integer>>adj,int i){
        visited[i]=true;
        for(int j=0;j<adj.get(i).size();j++){
            int val=adj.get(i).get(j);
            if(!visited[val]){
                dfs(visited,adj,val);
            }
        }
    }
    public void dfs1(Stack<Integer>st,int i,ArrayList<ArrayList<Integer>>adj,boolean visited[]){
        visited[i]=true;
        for(int j=0;j<adj.get(i).size();j++){
            int val=adj.get(i).get(j);
            if(!visited[val]){
                dfs1(st,val,adj,visited);
            }
        }
        st.push(i);
    }
}
