class Solution {
    public int knightDialer(int n) {
        int mod = (int) 1e9 + 7;
        int matrix[][] = new int[4][3];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(matrix[i], -1);
        }
        int dp[][][]=new int[4][3][n+1];
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int k = 1;
        for (int i = 0; i < 4; i++) {
            if (k > 9) {
                break;
            }
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = k;
                k++;
            }
        }
        matrix[3][1] = 0;
        int arr[][] = { { -2, 1 }, { -1, 2 }, { -2, -1 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { 1, 2 } };
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] != -1) {
                    sum=(sum+findValue(matrix, arr, i, j, mod, n,dp))%mod;
                }
            }
        }
        return sum;
    }

    public int findValue(int matrix[][], int arr[][], int i, int j, int mod, int n,int dp[][][]) {
        if (n==1) {
            return 1;
        }
        if(dp[i][j][n]!=-1){
            return dp[i][j][n];
        }
        int count=0;
        for(int k=0;k<8;k++){
            int x=i+arr[k][0];
            int y=j+arr[k][1];
            if(x>=0 && y>=0 && x<4 && y<3 && matrix[x][y]!=-1 ){
                count=(count+findValue(matrix,arr,x,y,mod,n-1,dp))%mod;
            }
        }
        dp[i][j][n]=count;
        return dp[i][j][n];
    }
}