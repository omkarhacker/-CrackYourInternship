class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int dp[]=new int[n+1];
       Arrays.fill(dp,-1);
       int val=findAns(n,x,y,z,dp);
       if(val<0){
           return 0;
       }
       return val;
    }
    public int findAns(int n,int x,int y,int z,int dp[]){
        if(n==0){
            return 0;
        }
        if(n<0){
            return Integer.MIN_VALUE;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int val1=0;
        int val2=0;
        int val3=0;
        //if(n>=x){
            val1=1+findAns(n-x,x,y,z,dp);
        //}
        //if(n>=y){
            val2=1+findAns(n-y,x,y,z,dp);
        //}
        //if(n>=z){
            val3=1+findAns(n-z,x,y,z,dp);
        //}
        return dp[n]=Math.max(val1,Math.max(val2,val3));
    }
}
