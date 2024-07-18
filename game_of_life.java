class Solution {
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        Boolean visited[][]=new Boolean[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(visited[i],null);
        }
        int arr[][]={{-1,0},{1,0},{0,-1},{0,1},{1,1},{1,-1},{-1,1},{-1,-1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int val=board[i][j];
                int count1=0;
                int count0=0;
                for(int k=0;k<8;k++){
                    int x=arr[k][0]+i;
                    int y=arr[k][1]+j;
                    if(x<0 || y<0 || x>=n || y>=m){
                        continue;
                    }
                    else{
                        if(board[x][y]==0){
                            count0++;
                        }
                        else{
                            count1++;
                        }
                    }
                }
                if(val==1){
                    if(count1<2){
                        visited[i][j]=false;
                    }
                    if(count1>3){
                        visited[i][j]=false;
                    }
                }
                else{
                    if(count1==3){
                        visited[i][j]=true;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]!=null && visited[i][j]==false && board[i][j]==1){
                    board[i][j]=0;
                }
                else if(visited[i][j]!=null && visited[i][j]==true && board[i][j]==0){
                    board[i][j]=1;
                }
            }
        }
    }
}