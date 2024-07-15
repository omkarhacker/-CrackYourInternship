class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int n=prices.length;
        int profit=0;
        for(int i=0;i<n;i++){
            if(prices[i]<buy){
                buy=prices[i];
            }
            else{
                int val=prices[i]-buy;
                profit=Math.max(profit,val);
            }
        }
        return profit;
    }
}