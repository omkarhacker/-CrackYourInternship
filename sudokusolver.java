class Solution {
    public void solveSudoku(char[][] board) {
        findAns(board,0,0);
    }
    public boolean findAns(char board[][],int i,int j){
        if(i==9){
            return true;
        }
        if(j==9){
           return findAns(board,i+1,0);
        }
        if(board[i][j]!='.'){
            return findAns(board,i,j+1);
        }
        for(int k=1;k<=9;k++){
            if(isTrue(board,i,j,k)){
                board[i][j]=(char)(k+'0');
                if(findAns(board,i,j+1)){
                    return true;
                }
                board[i][j]='.';
            }
        }
        return false;
    }
    public boolean isTrue(char board[][],int i,int j,int k){
        char ch=(char)(k+'0');
          for(int p=0;p<9;p++){
            if(board[p][j]==ch){
                return false;
            }
          }
          for(int p=0;p<9;p++){
            if(board[i][p]==ch){
                return false;
            }
          }
          int val1=(i/3)*3;
          int val2=(j/3)*3;
          for(int p=val1;p<val1+3;p++){
            for(int q=val2;q<val2+3;q++){
                if(board[p][q]==ch){
                    return false;
                }
            }
          }
          return true;
    }
}
