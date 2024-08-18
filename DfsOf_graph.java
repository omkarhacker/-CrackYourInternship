class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
       ArrayList<Integer>arr=new ArrayList<>();
       boolean visited[]=new boolean[V];
       findDfs(arr,adj,0,visited);
       return arr;
    }
    public void findDfs(ArrayList<Integer>arr,ArrayList<ArrayList<Integer>>adj,int i,boolean visited[]){
        visited[i]=true;
        arr.add(i);
        for(int j=0;j<adj.get(i).size();j++){
            int val=adj.get(i).get(j);
            if(!visited[val]){
                findDfs(arr,adj,val,visited);
            }
        }
    }
}