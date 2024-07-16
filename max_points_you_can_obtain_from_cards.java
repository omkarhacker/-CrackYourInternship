class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int n=cardPoints.length;
        int rightSum[]=new int[k];
        int leftSum[]=new int[k];
        int sum=0;
        for(int i=0;i<k;i++){
           sum=sum+cardPoints[i];
           leftSum[i]=sum;
        }
        sum=0;
        int j=0;
        for(int i=n-1;i>=n-k;i--){
            sum=sum+cardPoints[i];
            rightSum[j]=sum;
            j++;
        }
        int max=0;
        max=Math.max(max,rightSum[k-1]);
        max=Math.max(max,leftSum[k-1]);
        for(int i=0;i<k-1;i++){
            int sum1=rightSum[i]+leftSum[k-i-2];
            max=Math.max(max,sum1);
        }
        return max;
    }
}