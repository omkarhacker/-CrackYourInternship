class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        // code here
        int count=0;
        long mulWithout=1;
        long mul=1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                count++;
            }
            mul=mul*nums[i];
            if(nums[i]!=0){
                mulWithout=mulWithout*nums[i];
            }
        }
        long ans[]=new long[n];
        for(int i=0;i<n;i++){
            if(nums[i]==0 && count==1){
                ans[i]=mulWithout;
            }
            else if(nums[i]==0 && count>1){
                ans[i]=0;
            }
            else{
                ans[i]=mul/nums[i];
            }
            
        }
        return ans;
	} 
} 