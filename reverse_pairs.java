class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        int count[]=new int[1];
        divideArray(nums,count,0,n-1);
        return count[0];
    }
    public void divideArray(int nums[],int count[],int start,int end){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        divideArray(nums,count,start,mid);
        divideArray(nums,count,mid+1,end);
        mergeArray(nums,count,start,end,mid);
    }
    public void mergeArray(int nums[],int count[],int start,int end,int mid){
        int index=mid+1;
        for(int i=start;i<=mid;i++){
            while(index<=end && (long)nums[i]>2*(long)nums[index]){
                index++;
            }
            count[0]=count[0]+(index-(mid+1));
        }
        int i=start;
        int j=mid+1;
        int k=0;
        int temp[]=new int[end-start+1];
        while(i<=mid && j<=end){
            if(nums[i]<=nums[j]){
                temp[k]=nums[i];
                i++;
            }
            else{
                temp[k]=nums[j];
                j++;
            }
            k++;
        }
        while(i<=mid){
            temp[k]=nums[i];
            i++;
            k++;
        }
        while(j<=end){
            temp[k]=nums[j];
            j++;
            k++;
        }
        int p=0;
        for(int x=start;x<=end;x++){
            nums[x]=temp[p];
            p++;
        }
    }
}