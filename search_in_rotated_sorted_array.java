class Solution {
    public int search(int[] nums, int target) {
       int pivot=-1;
       int n=nums.length;
       for(int i=1;i<n;i++){
          if(nums[i]<nums[i-1]){
            pivot=i;
          }
       }
       int start=0;
       int end=0;
       if(pivot==-1){
        start=0;
        end=n-1;
       }
       else{
        if(target>=nums[pivot] && target<nums[0]){
            start=pivot;
            end=n-1;
        }
        else{
            start=0;
            end=pivot-1;
        }
       }
       int ans=-1;
       while(start<=end){
           int mid=start+(end-start)/2;
           if(nums[mid]==target){
            return mid;
           }
           if(nums[mid]<target){
            start=mid+1;
           }
           else{
            end=mid-1;
           }
       }
       return ans;
    }
}