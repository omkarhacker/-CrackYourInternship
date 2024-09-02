class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findQuick(nums,nums.length-k,0,nums.length-1);
    }
    public int findQuick(int nums[],int k,int start,int end){
        if(start<=end){
            int index=findVal(nums,k,start,end);
            if(index==k){
                return nums[index];
            }
            else if(index<k){
                return findQuick(nums,k,index+1,end);
            }
            else{
                return findQuick(nums,k,start,index-1);
            }
        }
        return -1;
    }
    public int findVal(int nums[],int k,int start,int end){
        int pivot=nums[start];
        int i=start;
        int j=end;
        while(i<=j){
            while(i<=end && nums[i]<=pivot){
                i++;
            }
            while(j>=start && nums[j]>pivot){
                j--;
            }
            if(i<j){
                swap(nums,i,j);
            }
        }
        swap(nums,start,j);
        return j;
    }
    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}