class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        char ch = word.charAt(0);
        int arr[][]={{0,1},{0,-1},{1,0},{-1,0}};
        boolean visited[][]=new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == ch) {
                    StringBuilder str=new StringBuilder();
                   
                    if(findWord(str,i,j,word,visited,board,arr,0)){
                        return true;
                    }
                    
                   
                }
            }
        }
        return false;
    }
    public boolean findWord(StringBuilder str,int i,int j,String word,boolean visited[][],char board[][],int arr[][],int p){
        if(word.length()==p){
          
            return true;
        }
        
        if(i<0 || i>=visited.length || j<0 || j>=visited[0].length || visited[i][j] || word.charAt(p)!=board[i][j]){
            return false;
        }
        
        
        visited[i][j]=true;
        for(int k=0;k<4;k++){
            int x=i+arr[k][0];
            int y=j+arr[k][1];
           
                if(findWord(str,x,y,word,visited,board,arr,p+1)){
                    return true;
                }
              
        }
        visited[i][j]=false;
        return false;
    }
}