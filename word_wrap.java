class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        // Code here 
        int dp[][]=new int[k+1][nums.length+1];
        for(int i=0;i<=k;i++){
            Arrays.fill(dp[i],-1);
        }
        return helperFunction(nums,k,1,nums[0],dp);
    }
    public int helperFunction(int nums[],int k,int index,int curr,int dp[][]){
        if(index==nums.length){
            return 0;
        }
        if(dp[curr][index]!=-1){
            return dp[curr][index];
        }
        int newspace=curr+1+nums[index];
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        if(newspace<=k){
            a=helperFunction(nums,k,index+1,newspace,dp);
        }
        b=(k-curr)*(k-curr)+helperFunction(nums,k,index+1,nums[index],dp);
        return dp[curr][index]=Math.min(a,b);
    }
}