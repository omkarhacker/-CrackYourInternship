class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int first=1;
        for(int i=0;i<n-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[first]=nums[i+1];
                first++;
            }
        }
        return first;
    }
}