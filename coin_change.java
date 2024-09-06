class Solution {
    public int coinChange(int[] coins, int amount) {
       int dp[]=new int[amount+1];
        Arrays.fill(dp,-1);
       return findAns(coins,amount,dp)==Integer.MAX_VALUE?-1:findAns(coins,amount,dp);
    }
    public int findAns(int coins[],int amount,int dp[]){
        if(amount<0){
            return Integer.MAX_VALUE;
        }
        if(amount==0){
            return 0;
        }
        if(dp[amount]!=-1){
            return dp[amount];
        }
        int val=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int ans=findAns(coins,amount-coins[i],dp);
            if(ans!=Integer.MAX_VALUE){
                val=Math.min(val,ans+1);
            }
        }
        return dp[amount]=val;
    }
}