class Solution {
    public int MinCoin(int[] nums, int amount) {
        // Code here
        int dp[][]=new int[nums.length][amount+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int val=findAns(nums,amount,0,dp);
        return val==Integer.MAX_VALUE?-1:val;
        
    }
    public int findAns(int nums[],int amount,int i,int dp[][]){
        if(amount==0){
            return 0;
        }
        if(i>=nums.length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int ans1=Integer.MAX_VALUE;
        if(nums[i]<=amount){
            int val=findAns(nums,amount-nums[i],i,dp);
            if(val!=Integer.MAX_VALUE){
                ans1=1+val;
            }
        }
        int ans2=findAns(nums,amount,i+1,dp);
        return dp[i][amount]=Math.min(ans1,ans2);
    }
}