class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left[]=new int[n];
        int right[]=new int[n];
        int leftMax=0;
        int rightMax=0;
        for(int i=0;i<n;i++){
            leftMax=Math.max(leftMax,height[i]);
            rightMax=Math.max(rightMax,height[n-i-1]);
            left[i]=leftMax;
            right[n-i-1]=rightMax;
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+Math.min(right[i],left[i])-height[i];
        }
        return sum;
    }
}