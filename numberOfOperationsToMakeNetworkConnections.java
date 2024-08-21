class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if(m<n-1){
            return -1;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        boolean visited[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                Dfs(visited,i,adj);
            }
        }
        if(count==1){
            return 0;
        }
        return count-1;
    }
    public void Dfs(boolean visited[],int i,ArrayList<ArrayList<Integer>>adj){
        visited[i]=true;
        for(int j=0;j<adj.get(i).size();j++){
            int val=adj.get(i).get(j);
            if(!visited[val]){
                Dfs(visited,val,adj);
            }
        }
    }
}