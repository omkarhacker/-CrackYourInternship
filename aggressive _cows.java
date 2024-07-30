class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int max=stalls[n-1];
        int firstmin=stalls[0];
        int secondmin=stalls[1];
        int ans=0;
        int start=0;
        int end=max-firstmin;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isPossible(mid,k,stalls,n)){
                ans=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int mid,int k,int stalls[],int n){
        int val=stalls[0]+mid;
        k--;
        for(int i=1;i<n;i++){
            if(val<=stalls[i]){
                k--;
                val=stalls[i]+mid;
            }
            if(k==0){
                return true;
            }
        }
        return false;
    }