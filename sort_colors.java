class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int start=0;
        int mid=0;
        int end=n-1;

        while(mid<=end){
            if(nums[mid]==0){
                swapFunction(nums,start,mid);
                start++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swapFunction(nums,mid,end);
                end--;
            }
        }

    }
    public void swapFunction(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}