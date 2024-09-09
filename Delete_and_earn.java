import java.util.HashSet;

class Solution {
    public int deleteAndEarn(int[] nums) {
       int max=0;
       int n=nums.length;
       for(int i=0;i<nums.length;i++){
        max=Math.max(max,nums[i]);
       }
        int arr[]=new int[max+1];
        for(int i=0;i<n;i++){
           arr[nums[i]]=arr[nums[i]]+nums[i];
        }
        int dp[]=new int[max+1];
        Arrays.fill(dp,-1);
        return findAns(arr , max,dp);
    }
    
    public int findAns(int arr[],int n,int dp[]) {
       if(n==0){
        return arr[0];
       }
       if(n<0){
        return 0;
       }
       if(dp[n]!=-1){
        return dp[n];
       }
       int take=0;
       int notTake=0;
       take=arr[n]+findAns(arr,n-2,dp);
       notTake=findAns(arr,n-1,dp);
       return dp[n]=Math.max(take,notTake);
    }
}
