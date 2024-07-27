class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length()-1;
        int m=t.length()-1;
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return findSubstring(s,t,n,m,dp);
    }
    public int findSubstring(String s,String t,int n,int m,int dp[][]){
        if(m==-1 && n==-1){
            return 1;
        }
        if(m==-1){
            return 1;
        }
        if(n==-1){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        int val=0;
        if(s.charAt(n)==t.charAt(m)){
            val=findSubstring(s,t,n-1,m-1,dp)+findSubstring(s,t,n-1,m,dp);
        }
        else{
            val=findSubstring(s,t,n-1,m,dp);
        }
        return dp[n][m]=val;
    }
}