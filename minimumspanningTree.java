class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
         int[][] matrix = new int[E][3];
        int index = 0;

        // Extract edges from the adjacency list
        for (int u = 0; u < V; u++) {
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int wt = neighbor[1];
                // Avoid adding the same edge twice (since it's an undirected graph)
                if (u < v) {
                    matrix[index][0] = u;
                    matrix[index][1] = v;
                    matrix[index][2] = wt;
                    index++;
                }
            }
        }
        Arrays.sort(matrix,Comparator.comparingInt(o->o[2]));
        int parent[]=new int[V];
        int rank[]=new int[V];
        for(int i=0;i<V;i++){
            parent[i]=i;
            rank[i]=0;
        }
        int total=0;
        for(int i=0;i<E;i++){
            int val1=matrix[i][0];
            int val2=matrix[i][1];
            int cost=matrix[i][2];
            int parent1=findParent(val1,parent);
            int parent2=findParent(val2,parent);
            if(parent1!=parent2){
                total=total+cost;
                formUnion(val1,val2,rank,parent);
            }
        }
        // for(int i=0;i<E;i++){
        //     System.out.println(matrix[i][0]+" "+matrix[i][1]+" "+matrix[i][2]);
        // }
        
        return total;
    }
    static int findParent(int i,int parent[]){
        if(parent[i]==i){
            return i;
        }
        return parent[i]=findParent(parent[i],parent);
    }
    static void formUnion(int a,int b,int rank[],int parent[]){
        int val1=findParent(a,parent);
        int val2=findParent(b,parent);
        if(val1==val2){
            return;
        }
        if(rank[val1]==rank[val2]){
            parent[val1]=val2;
            rank[val2]++;
        }
        else if(rank[val1]>rank[val2]){
            parent[val2]=val1;
        }
        else{
            parent[val1]=val2;
        }
    }
}