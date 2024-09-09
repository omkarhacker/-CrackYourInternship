class NumMatrix {
    int newMatrix[][];
    public NumMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        newMatrix=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int left = (j > 0) ? newMatrix[i][j - 1] : 0;
                int top = (i > 0) ? newMatrix[i - 1][j] : 0;
                int topLeft = (i > 0 && j > 0) ? newMatrix[i - 1][j - 1] : 0;

                newMatrix[i][j] = matrix[i][j] + left + top - topLeft;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
          int ans=0;
          ans=ans+newMatrix[row2][col2];
          if(row1-1>=0){
            ans=ans-newMatrix[row1-1][col2];
          }
          if(col1-1>=0){
            ans=ans-newMatrix[row2][col1-1];
          }
          if(col1-1>=0 && row1-1>=0){
             ans=ans+newMatrix[row1-1][col1-1];
          }
          return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */