class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        // Your code here
        if(m>n){
            return (long)-1;
        }
        int max=0;
        long sum=0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i];
            max=Math.max(max,arr[i]);
        }
        
        long start=max;
        long end=sum;
        long ans=0;
        while(start<=end){
            long mid=start+(end-start)/2;
            if(isTrue(mid,arr,n,m)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
    public static boolean isTrue(long mid,int arr[],int n,int m){
        int count=1;
        long max=0;
        for(int i=0;i<n;i++){
            if(max+arr[i]>mid){
                count++;
                max=arr[i];
                if(count>m){
                    return false;
                }
            }
            else{
                max=max+arr[i];
            }
        }
        return true;
    }
};