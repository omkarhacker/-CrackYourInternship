class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int arr[][]={{-1,0},{0,-1},{1,0},{0,1}};
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];
        int ans[]=new int[1];
        int count=0;
        int start=0;
        int end=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=-1){
                    count++;
                }
                if(grid[i][j]==1){
                    visited[i][j]=true;
                    start=i;
                    end=j;
                }
            }
        }
        findAns(start,end,grid,arr,visited,ans,1,count);
        return ans[0];
    }
    public void findAns(int i,int j,int grid[][],int arr[][],boolean visited[][],int ans[],int count,int total){
        if(grid[i][j]==2 && count==total){
           ans[0]++;
            return;
        }
        for(int k=0;k<4;k++){
            int x=i+arr[k][0];
            int y=j+arr[k][1];
            if(x>=0 && y>=0 && x<grid.length &&  y<grid[0].length && grid[x][y]!=-1 && !visited[x][y]){
                visited[x][y]=true;
                findAns(x,y,grid,arr,visited,ans,count+1,total);
                visited[x][y]=false;
            }
        }
    }
}