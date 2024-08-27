class Solution {
    public int[][] minCashFlow(int[][] transaction, int n) {
        // code here
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i]=arr[i]+transaction[j][i]-transaction[i][j];
            }
        }
        int ans[][]=new int[n][n];
        findAns(arr,ans);
        return ans;
    }
    public void findAns(int arr[],int transaction[][]){
        int max=findMax(arr);
        int min=findMin(arr);
        if(arr[max]==0 && arr[min]==0){
            return;
        }
        int minval=Math.min(-arr[min],arr[max]);
        arr[max]=arr[max]-minval;
        arr[min]=arr[min]+minval;
        transaction[min][max]=minval;
        findAns(arr,transaction);
    }
    public int findMax(int arr[]){
        int j=0;
        int min=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(min<arr[i]){
                min=arr[i];
                j=i;
            }
        }
        return j;
    }
    public int findMin(int arr[]){
        int j=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
                j=i;
            }
        }
        return j;
    }
}
