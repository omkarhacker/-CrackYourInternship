class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
       int n=grid.length;
       int m=grid[0].length;
       boolean visited[][]=new boolean[n][m];
       int count=0;
       int arr[][]={{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               if(!visited[i][j] && grid[i][j]=='1'){
                   count++;
                   Dfs(visited,grid,arr,i,j);
               }
           }
       }
       return count;
    }
    public void Dfs(boolean visited[][],char grid[][],int arr[][],int i,int j){
        visited[i][j]=true;
        for(int k=0;k<8;k++){
            int x=i+arr[k][0];
            int y=j+arr[k][1];
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && !visited[x][y] && grid[x][y]=='1'){
                Dfs(visited,grid,arr,x,y);
            }
        }
    }
}