class Solution {
    public int[] countBits(int n) {
        
        int ans[]=new int[n+1];
        if(n==0){
            ans[0]=0;
            return ans;
        }
        ans[0]=0;
        for(int i=1;i<=n;i++){
            if(i%2==1){
                ans[i]=ans[i/2]+1;
            }
            else{
                ans[i]=ans[i/2];
            }
        }
        return ans;
    }
}