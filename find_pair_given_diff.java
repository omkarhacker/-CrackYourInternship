class Solution {
    public int findPair(int n, int x, int[] arr) {
        // code here
        if(n<2){
            return -1;
        }
        Arrays.sort(arr);
        int start=0;
        int end=1;
        while(end<n && start<end){
            if(arr[end]-arr[start]==x){
                return 1;
            }
            else if(arr[end]-arr[start]<x){
                end++;
            }
            else{
                start++;
                if(start==end){
                    end++;
                }
            }
        }
        return -1;
    }
}