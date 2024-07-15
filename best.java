class Solution {
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return function(prices,0,1,dp);
    }
    public int function(int price[],int i,int buy,int dp[][]){
        if(i==price.length){
            return 0;
        }
        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        int val=0;
        if(buy==1){
           val=Math.max(function(price,i+1,0,dp)-price[i],function(price,i+1,1,dp));
        }
        else{
           val=Math.max(function(price,i+1,1,dp)+price[i],function(price,i+1,0,dp));
        }
        return dp[i][buy]=val;
    }
}