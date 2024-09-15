class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int a=graph.length;
        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                if(graph[i][j]){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int colored[]=new int[n];
        Arrays.fill(colored,-1);
        for(int i=0;i<n;i++){
            if(colored[i]==-1){
                if(!cancolor(i,colored,adj,m)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean cancolor(int i,int colored[],ArrayList<ArrayList<Integer>>adj,int m){
        
        
        if(i==colored.length){
            return true;
        }
        
        for(int j=1;j<=m;j++){
            if(isPossible(adj,j,colored,i)){
                colored[i]=j;
                if(cancolor(i+1,colored,adj,m)){
                    return true;
                }
                colored[i]=-1;
            }
        }
        
        return false;
    }
    public boolean isPossible(ArrayList<ArrayList<Integer>>adj,int j,int colored[],int val){
        for(int i=0;i<adj.get(val).size();i++){
            int val1=adj.get(val).get(i);
            if(colored[val1]==j){
                return false;
            }
        }
        return true;
    }
}