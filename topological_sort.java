class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        Stack<Integer>st=new Stack<>();
        boolean visited[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                findTopo(adj,i,visited,st);
            }
        }
        int ans[]=new int[st.size()];
        int i=0;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i++;
        }
        return ans;
    }
    static void findTopo(ArrayList<ArrayList<Integer>>adj,int i,boolean visited[],Stack<Integer>st){
        visited[i]=true;
        for(int j=0;j<adj.get(i).size();j++){
            int val=adj.get(i).get(j);
            if(!visited[val]){
                findTopo(adj,val,visited,st);
            }
        }
        st.add(i);
    }
}