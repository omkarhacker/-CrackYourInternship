class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int dp[][]=new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return findAns(nums,0,-1,dp);
    }
    public int findAns(int nums[],int i,int pre,int dp[][]){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i][pre+1]!=-1){
            return dp[i][pre+1];
        }
        int val1=0;
        int val2=0;
        if(pre==-1 || nums[pre]<nums[i]){
            val1=1+findAns(nums,i+1,i,dp);
        }
        val2=findAns(nums,i+1,pre,dp);
        int val=Math.max(val1,val2);
        dp[i][pre+1]=val;
        return val;
    }
}