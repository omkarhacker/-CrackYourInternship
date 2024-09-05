class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][][]=new int[m+1][n+1][strs.length];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return findValue(strs, m, n, 0, 0, 0,dp);
    }

    public int findValue(String strs[], int m, int n, int i, int j, int index,int dp[][][]) {
        if (index >= strs.length) {
            return 0;
        }
        if(dp[i][j][index]!=-1){
            return dp[i][j][index];
        }
        int ans1 = 0;
        int ans2 = 0;
        String str = strs[index];
        int count0 = 0;
        int count1 = 0;
        for (int k = 0; k < str.length(); k++) {
            if (str.charAt(k) == '0') {
                count0++;
            } else {
                count1++;
            }
        }
        if (count0 + i <= m && count1 + j <= n) {
            ans1 = 1 + findValue(strs, m, n, i + count0, j + count1, index + 1,dp);
        }
        ans2 = findValue(strs, m, n, i, j, index + 1,dp);
        return dp[i][j][index]=Math.max(ans1,ans2);
    }
}