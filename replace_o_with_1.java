class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        
        boolean visited[][]=new boolean[n][m];
        int arr[][]={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<n;i++){
            if(!visited[i][0] && a[i][0]=='O'){
                Dfs(visited,a,i,0,arr);
            }
            if(!visited[i][m-1] && a[i][m-1]=='O'){
                Dfs(visited,a,i,m-1,arr);
            }
        }
        for(int i=0;i<m;i++){
            if(!visited[0][i] && a[0][i]=='O'){
                Dfs(visited,a,0,i,arr);
            }
            if(!visited[n-1][i] && a[n-1][i]=='O'){
                Dfs(visited,a,n-1,i,arr);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false && a[i][j]=='O'){
                    a[i][j]='X';
                }
            }
        }
        return a;
    }
    static void Dfs(boolean visited[][],char a[][],int i,int j,int arr[][]){
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            int x=arr[k][0]+i;
            int y=arr[k][1]+j;
            if(x>=0 && y>=0 && x<a.length && y<a[0].length && !visited[x][y] && a[x][y]=='O'){
                Dfs(visited,a,x,y,arr);
            }
        }
    }
}