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
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                if(graph[i][j]){
                    adj.get(i).add(j);
                }
            }
        }
        int color[]=new int[n];
        if(isPossible(0,color,m,adj)){
            return true;
        }
        return false;
    }
    public boolean isPossible(int i,int color[],int totalColo,ArrayList<ArrayList<Integer>>adj){
        if(i==color.length){
            return true;
        }
        for(int k=1;k<=totalColo;k++){
            if(isTrue(color,i,k,adj)){
                color[i]=k;
                if(isPossible(i+1,color,totalColo,adj)){
                    return true;
                }
                color[i]=0;
            }
        }
        return false;
        
    }
    public boolean isTrue(int color[],int i,int k,ArrayList<ArrayList<Integer>>adj){
        
        for(int j=0;j<adj.get(i).size();j++){
            int val=adj.get(i).get(j);
            if(color[val]==k){
                return false;
            }
        }
        return true;
        
    }
}