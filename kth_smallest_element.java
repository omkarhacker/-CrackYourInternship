class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = isTrue(mid,matrix);
            if (val < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
    public int isTrue(int mid,int matrix[][]){
        int n=matrix.length;
        int sum=0;
        for(int i=0;i<n;i++){
            int val=findUpper(matrix[i],mid,0,matrix[0].length-1);
            System.out.println(val);
            sum=sum+val;
        }
        return sum;
    }
    public int findUpper(int arr[],int val,int start,int end){
           while(start<=end){
              int mid=start+(end-start)/2;
              if(arr[mid]>val){
                end=mid-1;
              }
              else{
                start=mid+1;
              }
           }
           return start;
    }

}