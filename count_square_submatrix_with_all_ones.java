class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j - 1 >= 0 && i - 1 >= 0 && matrix[i - 1][j - 1] == 1 && matrix[i - 1][j] == 1
                        && matrix[i][j - 1] == 1 && matrix[i][j]==1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],Math.min(dp[i-1][j],dp[i][j-1]));
                } else {
                    dp[i][j] = matrix[i][j];
                }
            }
        }
        int total=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                total=total+dp[i][j];
            }
        }
        return total;
    }
}