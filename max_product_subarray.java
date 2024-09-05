class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int prefix=1;
        int suffix=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            prefix=prefix*nums[i];
            max=Math.max(max,prefix);
            if(prefix==0){
                prefix=1;
            }
            suffix=suffix*nums[n-i-1];
            max=Math.max(max,suffix);
            if(suffix==0){
                suffix=1;
            }
        }
        return max;
    }
}