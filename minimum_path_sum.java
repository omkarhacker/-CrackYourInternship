class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        boolean visited[][]=new boolean[n][m];
        return findAns(grid,0,0,visited,dp);
    }
    public int findAns(int grid[][],int i,int j,boolean visited[][],int dp[][]){
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[grid.length-1][grid[0].length-1];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        visited[i][j]=true;
        int val1=Integer.MAX_VALUE;
        int val2=Integer.MAX_VALUE;
        if(i+1<grid.length && !visited[i+1][j]){
            val1=grid[i][j]+findAns(grid,i+1,j,visited,dp);
        }
         if(j+1<grid[0].length && !visited[i][j+1]){
            val2=grid[i][j]+findAns(grid,i,j+1,visited,dp);
        }
        visited[i][j]=false;
        return dp[i][j]=Math.min(val1,val2);
    }
}