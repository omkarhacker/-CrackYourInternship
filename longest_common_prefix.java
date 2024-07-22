class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,strs[i].length());
        }
        StringBuilder str=new StringBuilder();
        for(int i=0;i<min;i++){
            char ch=strs[0].charAt(i);
            for(int j=0;j<n;j++){
                if(strs[j].charAt(i)!=ch){
                    return str.toString();
                }
            }
            str.append(ch);
        }
        return str.toString();
    }
}