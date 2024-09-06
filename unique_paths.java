class Solution {
    public int uniquePaths(int m, int n) {
        boolean visited[][]=new boolean[m][n];
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        int arr[][]={{1,0},{0,1}};
        return findAns(m,n,0,0,visited,arr,dp);
    }
    public int findAns(int m,int n,int i,int j,boolean visited[][],int arr[][],int dp[][]){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        visited[i][j]=true;
        int val=0;
        for(int k=0;k<2;k++){
            int x=arr[k][0]+i;
            int y=arr[k][1]+j;
            if(x>=0 && x<m && y>=0 && y<n && !visited[x][y]){
                val=val+findAns(m,n,x,y,visited,arr,dp);
            }
        }
        visited[i][j]=false;
        return dp[i][j]=val;
    }
}