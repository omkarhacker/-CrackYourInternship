class Solution
{
    class Node{
        int val;
        int cost;
        Node(int val,int cost){
            this.val=val;
            this.cost=cost;
        }
    }
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        int n=matrix.length;
        ArrayList<ArrayList<Node>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && matrix[i][j]!=-1){
                    adj.get(i).add(new Node(j,matrix[i][j]));
                }
            }
        }
        for(int i=0;i<n;i++){
            int arr[]=findAns(i,adj);
            matrix[i]=arr;
        }
    }
    public int[] findAns(int i,ArrayList<ArrayList<Node>>adj){
        int n=adj.size();
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[i]=0;
        Queue<Integer>qu=new LinkedList<>();
        qu.add(i);
        while(!qu.isEmpty()){
            int val=qu.remove();
            for(int j=0;j<adj.get(val).size();j++){
                Node node=adj.get(val).get(j);
                int val1=node.val;
                int cost=node.cost;
                if(dist[val1]>cost+dist[val]){
                    dist[val1]=cost+dist[val];
                    qu.add(val1);
                }
            }
        }
        for(int j=0;j<n;j++){
            if(dist[j]==Integer.MAX_VALUE){
                dist[j]=-1;
            }
        }
        return dist;
    }
}