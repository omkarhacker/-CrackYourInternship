class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n=mat.length;
        int zeroIndex=-1;
        for(int i=0;i<n;i++){
            boolean iszero=false;
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    iszero=true;
                }
            }
            if(iszero==false){
                zeroIndex=i;
            }
        }
        if(zeroIndex==-1){
            return -1;
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(mat[i][zeroIndex]==1){
                count++;
            }
        }
        if(count!=n-1 || mat[zeroIndex][zeroIndex]!=0){
            return -1;
        }
        return zeroIndex;
    }
}