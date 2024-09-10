class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][]=new int[prices.length][k+1][2];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<=k;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
         return findAns(k,0,prices,0,dp);
    }
    public int findAns(int k,int i,int prices[],int buy,int dp[][][]){
        if(i>=prices.length){
            return 0;
        }
        if(k==0 && buy==0){
            return 0;
        }
        if(dp[i][k][buy]!=-1){
            return dp[i][k][buy];
        }
        int max1=0;
        int max2=0;
        if(buy==0){
            int val1=findAns(k-1,i+1,prices,1,dp)-prices[i];
            int val2=findAns(k,i+1,prices,0,dp);
            max1=Math.max(val1,val2);
        }else{
            int val3=findAns(k,i+1,prices,0,dp)+prices[i];
            int val4=findAns(k,i+1,prices,1,dp);
            max2=Math.max(val3,val4);
        }
        return dp[i][k][buy]=Math.max(max1,max2);
    }
}