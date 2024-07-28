class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        
        int val1=-1;
        int val2=Integer.MAX_VALUE;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]<=x){
                val1=Math.max(val1,arr[i]);
            }
            if(arr[i]>=x){
                val2=Math.min(arr[i],val2);
            }
        }
        if(val2==Integer.MAX_VALUE){
            val2=-1;
        }
        int ans[]={val1,val2};
        return ans;
    }
}
