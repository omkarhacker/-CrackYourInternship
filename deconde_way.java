class Solution {
    public int numDecodings(String s) {
        HashSet<String> hs = new HashSet<>();
        for (int i = 1; i <= 26; i++) {
            String str = i + "";
            hs.add(str);
        }
        int dp[]=new int[s.length()];
        Arrays.fill(dp,-1);
        return findAns(s, hs, 0,dp);
    }

    public int findAns(String s, HashSet<String> hs, int i,int dp[]) {
        if (i >= s.length()) {
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int val1 = 0;
        int val2 = 0;
        if(s.charAt(i)!='0'){
            val1 = findAns(s, hs, i + 1,dp);
        }
        if (i + 2 <= s.length()) {
            String str = s.substring(i, i + 2);
            if (hs.contains(str)) {
                val2 =val2+ findAns(s, hs, i + 2,dp);
            }
        }
        return dp[i]=val1 + val2;
    }
}