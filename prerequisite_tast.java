class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        int m=prerequisites.length;
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean visited[]=new boolean[N];
        boolean pathVisited[]=new boolean[N];
        for(int i=0;i<N;i++){
            if(!visited[i]){
                if(isCycle(visited,pathVisited,adj,i)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isCycle(boolean visited[],boolean pathVisited[],ArrayList<ArrayList<Integer>>adj,int i){
        visited[i]=true;
        pathVisited[i]=true;
        for(int k=0;k<adj.get(i).size();k++){
            int val=adj.get(i).get(k);
            if(!visited[val]){
                if(isCycle(visited,pathVisited,adj,val)){
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


