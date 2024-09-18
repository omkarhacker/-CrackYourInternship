class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        int n=stones.length;
        for(int i=0;i<n;i++){
            sum=sum+stones[i];
        }
        boolean visited[]=new boolean[n];
        int dp[][]=new int[n][sum];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return findAns(stones,sum,0,0,visited,dp);

    }
    public int findAns(int stones[],int sum,int curr,int i,boolean visited[],int dp[][]){
        if(i==stones.length){
            int diff=sum-curr;
            return Math.abs(diff-curr);
        }
        if(dp[i][curr]!=-1){
            return dp[i][curr];
        }
        int ans=Integer.MAX_VALUE;
        for(int j=i;j<stones.length;j++){
           
            ans=Math.min(ans,findAns(stones,sum,curr+stones[j],j+1,visited,dp));
           
        }
        return dp[i][curr]=ans;
    }
}