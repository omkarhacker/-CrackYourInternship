class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        for(int i=0;i<n;i++){
            int val=i+m;
            if(val>n){
                return -1;
            }
            else{
                String str=haystack.substring(i,val);
                if(str.equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }
}