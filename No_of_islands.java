class Solution {
    public int numIslands(char[][] grid) {
        int arr[][]={{-1,0},{1,0},{0,-1},{0,1}};
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    count++;
                    findIsland(grid,visited,i,j,arr);
                }
            }
        }
        return count;
    }
    public void findIsland(char grid[][],boolean visited[][],int i,int j,int arr[][]){
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            int x=i+arr[k][0];
            int y=j+arr[k][1];
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && !visited[x][y] && grid[x][y]=='1'){
                findIsland(grid,visited,x,y,arr);
            }
        }
    }
}