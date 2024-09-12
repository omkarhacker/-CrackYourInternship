class Solution {
    public int characterReplacement(String s, int k) {
        int count[]=new int[26];
        int start=0;
        int end=0;
        int max=0;
        int maxLen=0;
        while(end<s.length()){
            char ch=s.charAt(end);
            count[ch-'A']++;
            max=Math.max(max,count[ch-'A']);
                while(end-start+1-max>k){
                    count[s.charAt(start)-'A']--;
                    max=Math.max(max,count[s.charAt(start)-'A']);
                    start++;
                }
           if(end-start+1-max<=k){
                maxLen=end-start+1;
                end++;
            }
        }
        return maxLen;
    }
}