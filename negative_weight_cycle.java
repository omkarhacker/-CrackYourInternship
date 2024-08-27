class Solution
{
    
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int m=edges.length;
        if(m==0){
            return 0;
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[edges[0][0]]=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m;j++){
                int val1=edges[j][0];
                int val2=edges[j][1];
                int val3=edges[j][2];
                if(dist[val1]!=Integer.MAX_VALUE && dist[val2]>val3+dist[val1]){
                    dist[val2]=val3+dist[val1];
                }
            }
        }
        for(int i=0;i<m;i++){
                int val1=edges[i][0];
                int val2=edges[i][1];
                int val3=edges[i][2];
                if(dist[val1]!=Integer.MAX_VALUE && dist[val2]>val3+dist[val1]){
                    return 1;
                    //dist[val2]=val3+dist[val1];
                }
        }
        
        return 0;
    }
}