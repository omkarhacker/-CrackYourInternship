

// User function Template for Java

class Solution {
    public long getCount(int n) {
        // Your code goes here
        int matrix[][]=new int[4][3];
        for(int i=0;i<4;i++){
            Arrays.fill(matrix[i],-1);
        }
        int k=1;
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                matrix[i][j]=k;
                k++;
            }
        }
        int arr[][]={{-1,0},{1,0},{0,1},{0,-1}};
        long total=0;
        matrix[3][0]=-1;
        matrix[3][2]=-1;
        matrix[3][1]=0;
        long dp[][][]=new long[4][3][n];
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(matrix[i][j]!=-1){
                    total=total+findAns(matrix,i,j,arr,n-1,dp);
                }
            }
        }
        return total;
    }
    public long findAns(int matrix[][],int i,int j,int arr[][],int n,long dp[][][]){
        if(n==0){
            return 1;
        }
        if(dp[i][j][n]!=-1){
            return dp[i][j][n];
        }
        long val=0;
        for(int k=0;k<4;k++){
            int x=i+arr[k][0];
            int y=j+arr[k][1];
            if(x>=0 && y>=0 && x<4 && y<3 && matrix[x][y]!=-1){
                val=val+findAns(matrix,x,y,arr,n-1,dp);
            }
        }
        val=val+findAns(matrix,i,j,arr,n-1,dp);
        return dp[i][j][n]=val;
    }
}