import java.util.*;
class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int max=0;
        int sum=0;
        for(int i=0;i<n;i++){
           sum=sum+nums[i];
           max=Math.max(max,nums[i]);
        }
        int start=max;
        int end=sum;
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isPossible(mid,k,nums)){
              ans=mid;
              end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int mid,int k,int nums[]){
        int n=nums.length;
        int count=0;
        int sum=0;
        for(int i=0;i<n;i++){
           if(sum+nums[i]>mid){
              count++;
              sum=nums[i];
           }else{
            sum=sum+nums[i];
           }
        }
        count+=1;
        if(count<=k){
            return true;
        }
        return false;
    }
}