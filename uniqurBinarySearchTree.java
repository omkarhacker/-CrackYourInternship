class Solution {
    public int numTrees(int n) {
        
        return findAns(n,1);
    }
    public int findAns(int end,int start){
        if(start>end){
            return 1;
        }
        if(start==end){
            return 1;
        }
        int ans=0;
        for(int i=start;i<=end;i++){
            int left=findAns(i-1,start);
            int right=findAns(end,i+1);
            ans=ans+left*right;
        }
        return ans;
    }
}