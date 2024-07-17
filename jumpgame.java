class Solution {
    public boolean canJump(int[] nums) {
        Boolean dp[]=new Boolean[nums.length];
        Arrays.fill(dp,null);
        return findJump(nums,0,dp);
    }
    public boolean findJump(int nums[],int i,Boolean dp[]){
        if(i>=nums.length){
            return false;
        }
        if(i==nums.length-1){
            return true;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int val=nums[i];
        for(int j=1;j<=val;j++){
            if(findJump(nums,i+j,dp)){
                return dp[i]=true;
            }
        }
        return dp[i]=false;
    }
}